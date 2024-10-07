import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        this.data = d;
        left = right = null;
    }
}

class Solution {

        private static int count = 0;
        private static int result = -1;
        
    public static int KthLargestElement(Node root, int K) {
            inOrderTraversal(root,K);
            return result;
        }
    
    private static void inOrderTraversal(Node node, int k){
        if(node == null || count>=k){
            return ;
        }
        
        inOrderTraversal(node.right , k);
        count++;
        if(count == k){
            result = node.data;
            return;
        }
        inOrderTraversal(node.left,k);
    }
    
    public static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }
    
    public static void main(String []args){
        Node root = null;

        int[] values = { 2,81,42,87,66,90,45 };
        for (int value : values) {
            root = insert(root, value);
        }
        
        int ans = KthLargestElement(root,2);
        System.out.println("Kth Largest Element of given binary tree is: "+ans);
    }
}

import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data = d;
        left = right = null;
    }
}

class Solution {
    public static Node searchBST(Node root, int val) {
        while(root!=null && root.data!=val){
            root = val<root.data ? root.left : root.right;
        }
        return root;
    }
    
    public static void printTree(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            printTree(root.left);
            printTree(root.right);
        }
    }
    
    public static void main(String []args){
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(7);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        
        printTree(node);
        System.out.println();
        
        Node key = searchBST(node,2);
        printTree(key);
    }
}

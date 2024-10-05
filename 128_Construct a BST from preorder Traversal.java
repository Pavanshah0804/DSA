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
    public static Node bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    public static Node bstFromPreorder(int []arr,int bound,int []i){
        // Base case: If the entire array is processed or the current value exceeds the bound, return null
        if(i[0] == arr.length || arr[i[0]] > bound) return null;

        Node root = new Node(arr[i[0]++]);
         // Recursively construct the left subtree, ensuring the next values are smaller than the current node
        root.left = bstFromPreorder(arr, root.data, i);

        // Recursively construct the right subtree, where values must be smaller than the provided 'bound'
        root.right = bstFromPreorder(arr, bound, i);
        return root;
    }
    
    public static void printTree(Node root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
    
    public static void main(String []args){
        int[] preorder = {8, 5, 1, 7, 10, 12};
        Node root = bstFromPreorder(preorder);
        
        printTree(root);
    }
}
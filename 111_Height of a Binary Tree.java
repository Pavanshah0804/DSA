import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int d){
        data = d;
        left = right = null;
    }
}

class Solution{
    
    public static int maxDepth(Node node){
        if(node == null) return 0;
        
        int lh = maxDepth(node.left);
        int rh = maxDepth(node.right);
        
        return 1+Math.max(lh,rh);
    }
    
    public static void main(String []args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        int depth = maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
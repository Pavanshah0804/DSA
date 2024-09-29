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
    
    public static int diameterOfBinaryTree(Node node){
        int diameter[] = new int[1];
        height(node,diameter);
        
        return diameter[0];
        
    }
    
    private static int height(Node node,int []diameter){
        if(node == null) return 0;
        
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        
        
        diameter[0] = Math.max(lh+rh,diameter[0]);
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

        int diameter = diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }
}
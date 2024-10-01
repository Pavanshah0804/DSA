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
    
    public static int findMaxPath(Node node, int []maxi){
        if(node == null) return 0;

        //calculate maximum path for left and right subtree.
        int leftMaxPath = Math.max(0,findMaxPath(node.left,maxi));
        int rightMaxPath = Math.max(0,findMaxPath(node.right,maxi));
        
        //Update the overall maximum path sum including the current node.
        maxi[0] = Math.max(maxi[0], node.data + leftMaxPath + rightMaxPath);
        
        return Math.max(leftMaxPath,rightMaxPath) + node.data;
    }
    
    public static int maxPathSum(Node root){
        int []maxi = {Integer.MIN_VALUE};
        findMaxPath(root,maxi);
        return maxi[0];
        
    }
    public static void main(String []args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        
        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
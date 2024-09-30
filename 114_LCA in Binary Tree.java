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

class Solution{
    
    public static Node LCA(Node root,Node p,Node q){
        if(root == null || root == p || root == q){
            return root;
        }
        
        Node left = LCA(root.left,p,q);
        Node right = LCA(root.right,p,q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
    
    public static void main(String []args){
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        
        Node n1 = root.left.left;
        Node n2 = root.left.right.right;

        Node lca = LCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of two Nodes is " + lca.data);
        } else {
            System.out.println("LCA not found.");
        }    }
}
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Soltuion{
    public static List<Integer> rightsideView(Node root){
        List<Integer> res = new ArrayList<>();
        recursionRight(root,res,0);
        
        return res;
    }
    
    public static void recursionRight(Node root, List<Integer> res, int level){
        if(root == null) return;
        
        if(res.size() == level){
            res.add(root.data);
            recursionRight(root.right,res,level+1);
            recursionRight(root.right, res, level+1);
        }
    }
    
    public static List<Integer> leftsideView(Node root){
        List<Integer> res = new ArrayList<>();
        recursionLeft(root,res,0);
        
        return res;
    }
    
    public static void recursionLeft(Node root, List<Integer> res, int level){
        if(root == null) return;
        
        if(res.size() == level){
            res.add(root.data);
        }
        recursionLeft(root.left,res,level+1);
        recursionLeft(root.right,res,level+1);
    } 
    
    public static void main(String []args){
    
         // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<Integer> rightView = rightsideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();

        List<Integer> leftView = leftsideView(root);

        // Print the result for Left View
        System.out.print("Left View Traversal: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
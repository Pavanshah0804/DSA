//Recursive approach
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node next;
    
    Node(int d){
        data = d;
        left = right = next = null;
    }
}

class Solution{
    public static Node connect(Node root){
        if(root == null || root.left == null || root.right == null){
            return root;
        }
        
        root.left.next = root.right;
        
        if(root.next!=null){
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
    
    public static void printLevelOrder(Node root) {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " -> " + (current.next != null ? current.next.data : "null") + " | ");
            current = current.next;
        }
        System.out.println();
        if (root.left != null) printLevelOrder(root.left);
    }
    
    public static void main(String []args){
        
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        
        connect(node);

        System.out.println("Connected nodes at the same level:");
        printLevelOrder(node);
    }
}

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

class Solution{
    static Node tail = null;
    
    public static Node bToDLL(Node root){
        if(root == null){
            return null;
        }
        
        //Recursively Convert left subtree.
        Node head = bToDLL(root.left);
        
        //If tail null then this is first node.
        if(tail == null){
            head = root; // This will be head of DLL.
            tail = head; //Initialize tail to head.
        }else{
            //Link current node to tail.
            tail.right = root; //right pointer to current
            root.left = tail; //left pointer to tail
            tail = root; // move tail to current node.
        }
        
        //Recursively convert the right subtree.
        bToDLL(root.right);
        return head;
    }
    
    public static void printDLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "<->");
            current = current.right;
        }
        System.out.println("null");
    }
    
    public static void main(String []args){
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        // Convert Binary Tree to Doubly Linked List
        Node head = bToDLL(root);

        // Print the converted Doubly Linked List
        printDLL(head);
    }
}
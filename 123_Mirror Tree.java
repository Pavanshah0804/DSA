import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    public static void mirror(Node node) {
        if (node == null) {
            return;
        }

        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Construct the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        
        System.out.println("Inorder traversal before mirroring:");
        inorderTraversal(root);
        System.out.println();

        mirror(root);

        System.out.println("Inorder traversal after mirroring:");
        inorderTraversal(root);
    }
}

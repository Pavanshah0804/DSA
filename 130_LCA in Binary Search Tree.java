import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public static Node LCA(Node root, int n1, int n2) {
        
        if (root == null) return null;

        int curr = root.data;

        if (curr < n1 && curr < n2)
            return LCA(root.right, n1, n2);

        if (curr > n1 && curr > n2)
            return LCA(root.left, n1, n2);

        return root;
    }

    // Function to insert a new node in the BST
    public static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;

        int[] values = { 20, 8, 22, 4, 12, 10, 14 };
        for (int value : values) {
            root = insert(root, value);
        }

        System.out.println("Inorder traversal of the BST:");
        inorder(root);
        System.out.println();

        int n1 = 10, n2 = 14;
        
        Node lca = LCA(root, n1, n2);
        if (lca != null)
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.data);
        else
            System.out.println("LCA not found.");
    }
}

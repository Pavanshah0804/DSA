import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class Solution {
    
    public static void changeTree(Node root) {
        if (root == null) {
            return;
        }

        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }

        if (child >= root.data) {
            root.data = child;
        } else {
            if (root.left != null) {
                root.left.data = root.data;
            } else if (root.right != null) {
                root.right.data = root.data;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if (root.left != null) {
            tot += root.left.data;
        }
        if (root.right != null) {
            tot += root.right.data;
        }

        if (root.left != null || root.right != null) {
            root.data = tot;
        }
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
        // Create the binary tree
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.print("Binary Tree before modification: ");
        inorderTraversal(root);
        System.out.println();

        changeTree(root);

        System.out.print("Binary Tree after Children Sum Property: ");
        inorderTraversal(root);
        System.out.println();
    }
}
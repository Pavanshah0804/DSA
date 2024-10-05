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
    public static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTUtil(Node node, int minVal, int maxVal) {
        if (node == null) {
            return true;
        }

        if (node.data <= minVal || node.data >= maxVal) {
            return false;
        }

        return isBSTUtil(node.left, minVal, node.data) && isBSTUtil(node.right, node.data, maxVal);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(25);

        if (isBST(root)) {
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is not a BST");
        }
    }
}

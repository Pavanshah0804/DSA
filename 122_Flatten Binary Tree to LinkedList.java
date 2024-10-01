import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int x) {
        data = x;
        left = right = null;
    }
}

class Solution {
    public static void flatten(Node root) {
        Node curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // If yes, find the rightmost node in the left subtree.
                Node pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right; //move the next node on right side.
        }
    }
    public static void printPreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void printFlattenTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printFlattenTree(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right = new Node(7);
        root.right.left = new Node(8);

        
        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();
        flatten(root);

        System.out.print("Binary Tree After Flatten: ");
        printFlattenTree(root);
        System.out.println();
    }
}
                                
                            
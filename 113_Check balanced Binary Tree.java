import java.lang.Math;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {
    public static boolean isBalanced(Node root) {
        return dfsHeight(root) != -1;
    }
    public static int dfsHeight(Node root) {
        if (root == null) return 0;
        int leftHeight = dfsHeight(root.left);

        if (leftHeight == -1) 
            return -1;

        int rightHeight = dfsHeight(root.right);

        if (rightHeight == -1) 
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)  
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        if (isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}    
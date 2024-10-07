import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
        left = right = null;
    }
}

class Solution {
    static class NodeInfo {
        boolean isBST;
        int minValue, maxValue, sum, maxSum;

        NodeInfo(boolean isBST, int minValue, int maxValue, int sum, int maxSum) {
            this.isBST = isBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.sum = sum;
            this.maxSum = maxSum;
        }
    }

    public static int maxSum(Node root) {
        return helper(root).maxSum;
    }

    private static NodeInfo helper(Node node) {  // Made this method static
        if (node == null) {
            return new NodeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);  // Corrected min/max for null nodes
        }

        NodeInfo left = helper(node.left);
        NodeInfo right = helper(node.right);

        // Check if the current subtree is a valid BST
        if (left.isBST && right.isBST && node.data > left.maxValue && node.data < right.minValue) {
            int currentSum = left.sum + right.sum + node.data;
            return new NodeInfo(
                true,
                Math.min(left.minValue, node.data),
                Math.max(right.maxValue, node.data),
                currentSum,
                Math.max(currentSum, Math.max(left.maxSum, right.maxSum))  // Fixed incorrect use of Math.sum to Math.max
            );
        }

        return new NodeInfo(false, 0, 0, 0, Math.max(left.maxSum, right.maxSum));  // Return the max sum found so far
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(5);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(6);

        int ans = maxSum(root);  // Static method can be called directly
        System.out.println("Max sum of BST in the binary tree: " + ans);
    }
}

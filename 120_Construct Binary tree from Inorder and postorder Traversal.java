import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {
    public static Node buildTree(int n, int inorder[], int postorder[]) {
        if (inorder == null || postorder == null || n == 0) return null;

        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            inMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, 0, n - 1, postorder, 0, n - 1, inMap);
    }
    
    private static Node buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        Node root = new Node(postorder[postEnd]);
        
        // Find the index of the root in the inorder traversal
        int inRoot = inMap.get(postorder[postEnd]);
        
        // Number of nodes in the left subtree
        int numsLeft = inRoot - inStart;

        // Build the left and right subtrees
        root.left = buildTreeHelper(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, inMap);
        root.right = buildTreeHelper(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inMap);
        
        return root;
    }

    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); 
        printPreorder(node.left);          
        printPreorder(node.right);         
    }
    public static void main(String[] args) {
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        Node root = buildTree(in.length, in, post);
        System.out.print("Preorder Traversal: ");
        printPreorder(root); 
    }
}

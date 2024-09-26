import java.util.*;

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

    public static void preorder(Node root, List<Integer> arr) {
        
        if (root == null) {
            return;
        }
        
        arr.add(root.data);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

    public static List<Integer> preOrder(Node root) {
        List<Integer> arr = new ArrayList<>();
        preorder(root, arr);
        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = preOrder(root);

        System.out.print("PreOrder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
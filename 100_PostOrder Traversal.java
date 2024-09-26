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

    public static void postorder(Node root, List<Integer> arr) {
        
        if (root == null) {
            return;
        }
        
        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.data);
        
    }

    public static List<Integer> postOrder(Node root) {
        List<Integer> arr = new ArrayList<>();
        postorder(root, arr);
        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = postOrder(root);

        System.out.print("PostOrder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
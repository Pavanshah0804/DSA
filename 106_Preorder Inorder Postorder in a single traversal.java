import java.util.*;
import java.util.AbstractMap.SimpleEntry;

class Node {
    int val;
    Node left;
    Node right;
    
    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {
    public static List<List<Integer>> preInPostTraversal(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        Stack<SimpleEntry<Node, Integer>> st = new Stack<>();
        st.push(new SimpleEntry<>(root, 1));  // Specify Node and Integer explicitly
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        if (root == null) return result;
        
        while (!st.isEmpty()) {
            SimpleEntry<Node, Integer> it = st.pop();  // Explicit type here as well
            if (it.getValue() == 1) {
                pre.add(it.getKey().val);
                it.setValue(2);
                st.push(it);
                
                if (it.getKey().left != null) {
                    st.push(new SimpleEntry<>(it.getKey().left, 1));
                }
            } else if (it.getValue() == 2) {
                in.add(it.getKey().val);
                it.setValue(3);
                st.push(it);
                
                if (it.getKey().right != null) {
                    st.push(new SimpleEntry<>(it.getKey().right, 1));
                }
            } else {
                post.add(it.getKey().val);
            }
        }
        
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }
    
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> pre, in, post;
        List<List<Integer>> traversals = preInPostTraversal(root);

        pre = traversals.get(0);  // Preorder is at index 0
        in = traversals.get(1);   // Inorder is at index 1
        post = traversals.get(2); // Postorder is at index 2

        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }
}

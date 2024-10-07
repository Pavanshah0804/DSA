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

    // Serializes a binary tree to a string using level order traversal
    public static ArrayList<Integer> serialize(Node root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res; //Base case
        
        Queue<Node> q = new LinkedList<>(); 
        
        q.offer(root); // Add the root node to the queue
        
        // Traverse the tree in level order
        while (!q.isEmpty()) {
            Node node = q.poll(); // Get the current node from the queue
            
            // If the current node is null, append a placeholder "#" to the result
            if (node == null) {
                res.add(-1);
                continue;
            }
            
            // Append the data of the node to the result
            res.add(node.data);
            
            // Add the left and right children to the queue, even if they are null
            q.offer(node.left);
            q.offer(node.right);
        }
        return res;
    }

    // Deserializes a string back into a binary tree
    public static Node deserialize(ArrayList<Integer> A) {
        if (A.size() == 0 || A.get(0) == -1) return null; //Base case
        
        // Initialize the root of the tree with the first value
        Node root = new Node(A.get(0)); 
        Queue<Node> q = new LinkedList<>(); 
        
        q.offer(root); // Add the root node to the queue
        int i = 1;
        
        while(!q.isEmpty()) {
            Node parent = q.poll(); // Get the parent node from the queue
            
            // If the left child is not a placeholder, create the left node and add it to the queue
            if (i<A.size() && A.get(i)!= -1) {
                Node left = new Node(A.get(i));
                parent.left = left;
                q.offer(left);
            }
            i++;
            
            // Move to the right child (advance the index)
            if (i<A.size() && A.get(i)!= -1) {
                Node right = new Node(A.get(i));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root; 
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left); 
        System.out.print(root.data + " "); 
        inorder(root.right); 
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        // Print the original tree using inorder traversal
        System.out.print("Original Tree: ");
        inorder(root);
        System.out.println();

        // Serialize the tree to a string
        ArrayList<Integer> serialized = serialize(root);
        System.out.print("Serialized: ");
        for(int i: serialized){
            System.out.print(i+" ");
        }
        System.out.println();

        // Deserialize the string back into a tree
        Node deserialized = deserialize(serialized);

        // Print the deserialized tree using inorder traversal
        System.out.print("Tree after deserialization: ");
        inorder(deserialized);
        System.out.println();
    }
}
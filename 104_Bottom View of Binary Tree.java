import java.util.*;

class Node {
    int data;   
    int hd;     // Horizontal distance from the root
    Node left;
    Node right; 
    
    public Node(int val) {
        data = val;
        hd = Integer.MAX_VALUE;  
        left = null;
        right = null;
    }
}

class Solution {
    
    public static List<Integer> bottomView(Node root) {
        List<Integer> ans = new ArrayList<>();
    
        if(root == null) {
            return ans;
        }
        
        // Map to store the horizontal distance (hd) as the key and node's data as the value
        Map<Integer, Integer> map = new TreeMap<>();
        
        Queue<Node> q = new LinkedList<>();
        root.hd = 0;  
        q.add(root);  
        
        // BFS traversal of the tree
        while(!q.isEmpty()) {
            Node temp = q.remove();  
            int hd = temp.hd;       
            
            // Put the node's data in the map for its horizontal distance (overwrites if a node exists)
            map.put(hd, temp.data);
            
            // Process the left child if it exists
            if(temp.left != null) {
                temp.left.hd = hd - 1;  // Left child has a horizontal distance of parent - 1
                q.add(temp.left);       // Add the left child to the queue
            }
            
            // Process the right child if it exists
            if(temp.right != null) {
                temp.right.hd = hd + 1; // Right child has a horizontal distance of parent + 1
                q.add(temp.right);      // Add the right child to the queue
            }
        }
        
        // Transfer values from the map to the result list
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());  
        }
        
        return ans;  
    }

    public static void main(String[] args) {
        Node root = new Node(1);            
        root.left = new Node(2);            
        root.left.left = new Node(4);       
        root.left.right = new Node(10);      
        root.left.left.right = new Node(5);  
        root.left.left.right.right = new Node(6); 
        root.right = new Node(3);           
        root.right.right = new Node(10);     
        root.right.left = new Node(9);
        
        List<Integer> bottomView = bottomView(root);

        System.out.println("Bottom View Traversal: ");
        for(int node : bottomView) {
            System.out.print(node + " ");
        }
    }
}

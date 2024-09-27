import java.util.*;

class TreeNode {
    int val;           
    TreeNode left;     
    TreeNode right;    
    
    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {
    
    public static List<Integer> getPreorder(TreeNode root) {
        List<Integer> arr = new ArrayList<>();  
        
        TreeNode current = root;  
        
        while (current != null) {
            if (current.left == null) {
                arr.add(current.val);
                current = current.right;
            } else {
                // Find the preorder predecessor of the current node
                TreeNode prev = current.left;
                // Move to the rightmost node of the left subtree (preorder predecessor)
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;    
                }
                
                if (prev.right == null) {
                    // Create a temporary thread by linking the predecessor's right to the current node
                    prev.right = current;
                    
                    //Add whenever you visit this node in preorer is only change from Morris Preorder.
                    arr.add(current.val); // key change 
                    
                    // Move current to its left child to continue traversal
                    current = current.left;
                } else {
                    // The left subtree has already been visited, so remove the thread
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return arr;  
    }
    
    public static void main(String []args) {
        
        TreeNode root = new TreeNode(1);  
        root.left = new TreeNode(2);      
        root.right = new TreeNode(3);     
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5);

        List<Integer> inorder = getPreorder(root);

        System.out.print("Binary Tree Morris Preorder Traversal: ");

        for (int i : inorder) {
            System.out.print(i + " ");
        }
        System.out.println();  
    }
}

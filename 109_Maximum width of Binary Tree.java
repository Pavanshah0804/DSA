import java.util.*;

class TreeNode {
    int data;           
    TreeNode left;     
    TreeNode right;    


    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution{
    
    //Global variable to store max width of the tree.
    private static int globalMax;
    
    //List to store global variable at each level.
    private static List<Integer> minIndex;
 
    public static int widthOfBinaryTree(TreeNode root){
        globalMax = 0;
        minIndex = new ArrayList<>();
        helper(root,0,1);
        return globalMax;
    } 
    
    private static void helper(TreeNode node, int height, int index){
        if(node == null) return;
        
        if(height > minIndex.size()-1){
            minIndex.add(index);
        }
        
        int currentWidth = index - minIndex.get(height) + 1;
        
        helper(node.left, height + 1, 2*index);
        helper(node.right, height + 1, 2*index+1);
        globalMax = Math.max(globalMax, currentWidth);
    }    
    
    public static void main(String []args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Calling the method to calculate the maximum width of the binary tree
        int maxWidth = widthOfBinaryTree(root);

        // Printing the result
        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}
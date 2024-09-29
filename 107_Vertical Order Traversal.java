import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;  
        right = null; 
    }
}

class Solution {
    
    public static List<List<Integer>> verticalTraversal(TreeNode root){
        
        //Treemap to store columns and their corresponding nodes, ensuring sorted keys
        Map<Integer, List<int []>> nodes = new TreeMap<>();
        
        //Perform DFS starting at the root 0 and column 0
        dfs(root,0,0,nodes);
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Process each column in the sorted order of keys (TreeMap ensures sorted keys)
        for(List<int []>list : nodes.values()){
            // Sort nodes in each column first by row, then by value if rows are the same
            Collections.sort(list,(a,b) -> a[0] != b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]));
            
            List<Integer> columnNodes = new ArrayList<>();
            // Extract the node values and add them to the result for this column
            for(int []node: list){
                columnNodes.add(node[1]);
            }
            result.add(columnNodes); // Add the sorted values of the current columns to the result.
        }
        
        return result;
    }
    
    public static void dfs(TreeNode root, int row, int col, Map<Integer, List<int[]>> nodes){
        if(root == null) return;
        
        //Check if the column exists in the map. if not then initialize new arraylist.
        if(!nodes.containsKey(col)){
            nodes.put(col,new ArrayList<>());
        }
        
        // Add the node's row and value to the list corresponding to the column
        nodes.get(col).add(new int[]{row,root.val});
        
        dfs(root.left,row+1,col-1,nodes);
        dfs(root.right,row+1,col+1,nodes);
    }
    
    private static void printResult(List<List<Integer>> result) {
        
        for (List<Integer> level : result) {
            
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println(); 
        }
        System.out.println(); 
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        
        // Perform vertical traversal on the binary tree
        List<List<Integer>> verticalTraversal = verticalTraversal(root);

        // Print the result of the vertical traversal
        System.out.print("Vertical Traversal: ");
        printResult(verticalTraversal);
    }
}
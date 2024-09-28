import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Solution{
    
    public static List<List<Integer>> Paths(Node root){
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPath(root,currentPath,allPath);
        return allPath;
        
    }
    
    private static void findPath(Node root, List<Integer> currentPath, List<List<Integer>> allPath){
        if(root == null) return;
        
        currentPath.add(root.data);
        
        if(root.left == null && root.right == null){
            allPath.add(new ArrayList<>(currentPath));
        }
        
        findPath(root.left, currentPath, allPath);
        findPath(root.right, currentPath, allPath);
        
        // Backtrack by removing the current node's data before returning to the caller
        currentPath.remove(currentPath.size()-1);
    }
    
    public static void printPaths(List<List<Integer>> paths){
        for(List<Integer> path : paths){
            for(int value: path){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String []args){
        
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        // Find all paths
        List<List<Integer>> paths = Paths(root);

        // Print all paths
        printPaths(paths);
    }
}
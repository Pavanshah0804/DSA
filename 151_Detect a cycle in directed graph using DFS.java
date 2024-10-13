import java.util.*;

class Solution {
    
    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
     
        int visited[] = new int[N];      
        int dfsVisited[] = new int[N];  
        
        
        for (int i = 0; i < N; i++) {
            // If the node has not been visited, check for a cycle starting from it
            if (visited[i] == 0) {
                if (checkCycle(i, adj, visited, dfsVisited)) return true;
            }
        }
        // If no cycles were detected, return false
        return false;
    }
    
    
    public static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int visited[], int dfsVisited[]) {
        visited[node] = 1;
        dfsVisited[node] = 1;
        
        // Traverse all adjacent nodes of the current node
        for (int it : adj.get(node)) {
            // If the adjacent node is not visited, recursively check for a cycle
            if (visited[it] == 0) {
                if (checkCycle(it, adj, visited, dfsVisited)) return true;
            }
            // If the adjacent node is visited and also in the current DFS path, a cycle is found
            else if (dfsVisited[it] == 1) {
                return true;
            }
        }
        
        // Backtrack: Unmark the current node from the DFS path
        dfsVisited[node] = 0;
        return false;
    }
    
    
    public static void main(String[] args) {
        int V = 6;  
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        
        adj.get(1).add(2);  
        adj.get(2).add(3);  
        adj.get(3).add(4);  
        adj.get(3).add(5);  
        adj.get(4).add(2);  
    
        boolean ans = isCyclic(V, adj);
        
        if (ans)
            System.out.println("True");  
        else
            System.out.println("False"); 
    }
}

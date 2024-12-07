import java.util.*;

class Solution{
    
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        // Initialize a visited array to track visited nodes
        int visited[] = new int [V];
        
        Stack<Integer> st = new Stack<>();
        
        // Step 1: Perform DFS to fill the stack with nodes in the order of their finishing time
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                dfs(i, visited, adj, st);
            }
        }
        
        // Step 2: Reverse the graph (transpose)
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        
        // Initialize the transposed graph adjacency list
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<Integer>());
        }
        
        // Reverse the edges of the graph
        for(int i=0;i<V;i++){
            visited[i]  = 0; // Reset the visited array for the second DFS pass
            for(Integer it: adj.get(i)){
                adjT.get(it).add(i); // Reverse the direction of the edges
            }
        }
        
        // Step 3: Perform DFS based on the order in the stack for the transposed graph
        int scc = 0; // Variable to count the number of SCCs
        while(!st.isEmpty()){
            int node = st.pop(); // Get the node from the stack
            
            // If the node is not visited, it's the start of a new SCC
            if(visited[node] == 0){
                scc++; // Increment the SCC count
                dfs(node, visited, adjT); // Perform DFS on the transposed graph
            }
        }
        
        return scc; // Return the total number of SCCs
     }
     
     // DFS function with stack to fill nodes based on their finishing time
     public static void dfs(int node, int []visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] = 1; // Mark the node as visited
        
        // Explore all the neighbors of the current node
        for(Integer it: adj.get(node)){
            if(visited[it] == 0){
                dfs(it, visited, adj, st); // Recursively visit the neighbors
            }
        }
        st.push(node); // Push the node onto the stack after visiting all neighbors
     }
     
     // DFS function for the transposed graph, no stack needed
     public static void dfs(int node, int []visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1; // Mark the node as visited
        
        // Explore all the neighbors in the transposed graph
        for(Integer it: adj.get(node)){
            if(visited[it] == 0){
                dfs(it, visited, adj); // Recursively visit the neighbors
            }
        }
     }
    
     public static void main (String[] args) {
        int n = 5; 
        int[][] edges = {
            {1, 0}, {0, 2},
            {2, 1}, {0, 3},
            {3, 4}
        };
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}

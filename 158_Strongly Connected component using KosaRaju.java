import java.util.*;

class Solution{
    
     public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        int visited[] = new int [V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                dfs(i,visited,adj,st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++){
            visited[i]  = 0;
            for(Integer it: adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            
            if(visited[node] == 0){
                scc++;
                dfs(node,visited,adjT);
            }
        }
        
        return scc;
     }
     
     public static void dfs(int node, int []visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] = 1;
        for(Integer it:adj.get(node)){
            if(visited[it] == 0){
                dfs(it,visited,adj,st);
            }
        }
        st.push(node);
     }
     public static void dfs(int node, int []visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        for(Integer it:adj.get(node)){
            if(visited[it] == 0){
                dfs(it,visited,adj);
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
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}
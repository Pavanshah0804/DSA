import java.util.*;

class Solution {
    
    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[N];

        for (int i = 0; i < N; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int cnt = 0;
        
        // Process the vertices in the queue
        while (!q.isEmpty()) {
            Integer node = q.poll(); 
            cnt++; 
            
            // Decrease the indegree of all adjacent vertices
            for (Integer it : adj.get(node)) {
                indegree[it]--; // Decrease indegree
                
                // If indegree becomes zero, add it to the queue
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // If the count of processed vertices is less than N, there is a cycle
        if (cnt == N) {
            return false; // No cycle
        }
        return true; 
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

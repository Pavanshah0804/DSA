import java.util.*;

class Solution {

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // Initialize the distance array with a very large value (infinity)
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        
        dist[src] = 0;

        //Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                // If the source vertex has been relaxed and a shorter path is found, update the distance
                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation to check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }
        return dist;
    }
    
    
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        int[][] edges = {
            {3, 2, 6},
            {5, 3, 1},
            {0, 1, 5},
            {1, 5, -3},
            {1, 2, -2},
            {3, 4, -2},
            {2, 4, 3}
        };

        int[] dist = bellmanFord(V, edges, S);
        if (dist.length == 1 && dist[0] == -1) {
            System.out.println("Negative weight cycle detected.");
        } else {
            for (int i = 0; i < V; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println();
        }
    }
}

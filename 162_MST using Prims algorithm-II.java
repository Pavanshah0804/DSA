import java.util.*;

class Pair {
    int node;       // Node number
    int distance;   // Weight of the edge connecting to the node
    
    // Constructor to initialize node and distance
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    // Function to find the sum of weights of the Minimum Spanning Tree (MST)
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Priority queue to fetch the edge with the smallest weight
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        
        // Visited array to track nodes included in the MST
        int[] vis = new int[V];
        
        // Start with node 0 and add it to the priority queue with weight 0
        pq.add(new Pair(0, 0));
        int sum = 0; // Variable to store the total weight of the MST
        
        // Continue until the priority queue is empty
        while (pq.size() > 0) {
            // Fetch the node with the smallest weight
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            // Skip if the node is already visited
            if (vis[node] == 1) continue;
            
            // Mark the node as visited and add the weight to the MST sum
            vis[node] = 1;
            sum += wt;
            
            // Traverse all adjacent nodes of the current node
            for (int[] neighbour : adj.get(node)) {
                int adjNode = neighbour[0];       // Adjacent node
                int edgeWeight = neighbour[1];   // Weight of the edge
                
                // Add the edge to the priority queue if the adjacent node is not visited
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edgeWeight));
                }
            }
        }
        
        // Return the total weight of the MST
        return sum;
    }
    
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 6; // Number of edges
        
        // Input graph edges: [u, v, w], where u and v are nodes, and w is the edge weight
        int[][] edges = {
            {0, 1, 2}, 
            {0, 2, 1}, 
            {1, 2, 1}, 
            {2, 3, 2}, 
            {3, 4, 1}, 
            {4, 2, 2}
        };
        
        // Initialize the adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            // Add edge u -> v
            adj.get(u).add(new int[] {v, w});
            // Add edge v -> u (since the graph is undirected)
            adj.get(v).add(new int[] {u, w});
        }
        
        // Call the spanningTree function to find the MST weight
        int mstWeight = spanningTree(V, E, adj);
        
        // Print the total weight of the MST
        System.out.println("The sum of all edge weights in the MST: " + mstWeight);
    }
}

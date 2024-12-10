import java.util.*;

// Helper class to represent a node and its associated edge weight
class Pair {
    int node;       // The node number
    int distance;   // The weight of the edge connecting to the node
    
    // Constructor to initialize the node and distance
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Priority queue to select the edge with the smallest weight
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
        // Visited array to track nodes already included in the MST
        int[] vis = new int[V];
        
        // Start with the first node (0) and add it to the priority queue with weight 0
        pq.add(new Pair(0, 0));
        int sum = 0; // Variable to store the sum of weights in the MST
        
        // Process until the priority queue is empty
        while (pq.size() > 0) {
            // Extract the edge with the smallest weight
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            // Skip if the node is already visited
            if (vis[node] == 1) continue;
            
            // Mark the node as visited and add the edge weight to the total sum
            vis[node] = 1;
            sum += wt;
            
            // Explore all adjacent nodes of the current node
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edw = adj.get(node).get(i).get(1); // Edge weight
                int adjNode = adj.get(node).get(i).get(0); // Adjacent node
                
                // Add the edge to the priority queue if the adjacent node is not visited
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edw));
                }
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int V = 5; 
        
        // Adjacency list representation of the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        // Input graph as edges: [u, v, w] where u and v are nodes, and w is the weight
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate adjacency list
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            // Add edge from u to v
            ArrayList<Integer> tmp1 = new ArrayList<>();
            tmp1.add(v);
            tmp1.add(w);
            adj.get(u).add(tmp1);
            
            // Add edge from v to u (since the graph is undirected)
            ArrayList<Integer> tmp2 = new ArrayList<>();
            tmp2.add(u);
            tmp2.add(w);
            adj.get(v).add(tmp2);
        }
        
        // Find the MST and print its total weight
        int sum = spanningTree(V, adj);
        System.out.println("The sum of all edge weights: " + sum);
    }
}

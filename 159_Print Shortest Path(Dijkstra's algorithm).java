import java.util.*;

class Pair {
    int first;  // Distance or weight
    int second; // Node or vertex number
    
    // Constructor to initialize the pair with given values
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        // Create an adjacency list to store the graph
        // Each node points to a list of pairs {neighbor node, edge weight}
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());  // Initialize empty lists for each node
        }
        
        // Populate the adjacency list using the given edges
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2])); // Add edge (u -> v) with weight
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2])); // Add edge (v -> u) for undirected graph
        }
        
        // Priority queue to store pairs {distance, node}, sorted by distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        
        // Array to store the shortest distance from the source node to each node
        int  []dist = new int[n + 1];
        // Array to store the parent of each node to reconstruct the path
        int []parent = new int[n + 1];
        
        // Initialize distances to a large value (infinity) and set each node as its own parent
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) (1e9);  // Equivalent to infinity
            parent[i] = i;          // Each node is its own parent initially
        }
        
        // Distance to the source node (node 1) is 0
        dist[1] = 0;
        // Add the source node to the priority queue with distance 0
        pq.add(new Pair(0, 1));
        
        // Dijkstra's algorithm loop
        while (!pq.isEmpty()) {
            // Get the node with the smallest distance from the priority queue
            Pair it = pq.peek();
            int node = it.second;
            int dis = it.first;
            
            pq.remove(); // Remove the current node from the queue
            
            // Iterate through all adjacent nodes of the current node
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;  // Neighbor node
                int edW = iter.second;     // Weight of the edge to the neighbor
                
                // If a shorter path to adjNode is found, update the distance and parent
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;    // Update the shortest distance
                    pq.add(new Pair(dist[adjNode], adjNode)); // Add updated distance to the priority queue
                    parent[adjNode] = node;       // Update the parent of adjNode
                }
            }
        }
        
        // Store the final path from node 1 to node n
        List<Integer> path = new ArrayList<>();
        
        // If the distance to node n is still infinity, there is no path
        if (dist[n] == 1e9) {
            path.add(-1);  // Return -1 to indicate no path exists
            return path;
        }
        
        // Reconstruct the path from node n to the source (node 1) using the parent array
        int node = n;
        while (parent[node] != node) {
            path.add(node);  // Add the current node to the path
            node = parent[node];  // Move to the parent node
        }
        
        path.add(1);  // Add the source node to the path
        
        Collections.reverse(path);  // Reverse the path to get the correct order from source to destination
        return path;  // Return the final path
    }
    
    public static void main(String[] args) {
        int V = 5, E = 6;  // Number of vertices and edges
        int[][] edges = {
            {1, 2, 2},  // Edge between node 1 and node 2 with weight 2
            {2, 5, 5},  // Edge between node 2 and node 5 with weight 5
            {2, 3, 4},  // Edge between node 2 and node 3 with weight 4
            {1, 4, 1},  // Edge between node 1 and node 4 with weight 1
            {4, 3, 3},  // Edge between node 4 and node 3 with weight 3
            {3, 5, 1}   // Edge between node 3 and node 5 with weight 1
        };
        
        // Find the shortest path and print it
        List<Integer> path = shortestPath(V, E, edges);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println(); 
    }
}

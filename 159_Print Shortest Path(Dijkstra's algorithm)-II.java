import java.util.*;

class iPair {
    int first;  // Distance or weight
    int second; // Node index
    
    public iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to find the shortest distance of all vertices from the source vertex src.
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances with infinity
        
        PriorityQueue<iPair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.add(new iPair(0, src)); 
        dist[src] = 0;
        
        while (!pq.isEmpty()) {
            iPair current = pq.poll();
            int u = current.second;
            
            for (iPair neighbour : adj.get(u)) {
                int v = neighbour.first; // Adjacent node
                int weight = neighbour.second;
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new iPair(dist[v], v));
                }
            }
        }
        
        // Convert distance array to a list to return
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]); // Handle unreachable nodes
        }
        return result;
    }
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        int E = 9; // Number of edges
        
        // Creating the adjacency list for the graph
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Adding edges to the graph: u, v, weight
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 1, 3, 5);
        addEdge(adj, 2, 3, 8);
        addEdge(adj, 2, 4, 10);
        addEdge(adj, 3, 4, 2);
        addEdge(adj, 3, 5, 6);
        addEdge(adj, 4, 5, 3);
        
        int src = 0; // Source vertex
        
        ArrayList<Integer> distances = dijkstra(adj, src);
        
        // Print the shortest distances from the source to all nodes
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < distances.size(); i++) {
            System.out.println("Node " + i + ": " + distances.get(i));
        }
    }
    
    // Helper function to add an edge to the adjacency list
    static void addEdge(ArrayList<ArrayList<iPair>> adj, int u, int v, int weight) {
        adj.get(u).add(new iPair(v, weight));
        adj.get(v).add(new iPair(u, weight)); // Since the graph is undirected
    }
}

import java.util.*;

// DisjointSet class for Union-Find operations
class DisjointSet {
    // Lists to store rank, parent, and size of sets
    static List<Integer> rank = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();
    static List<Integer> size = new ArrayList<>();
    
    // Constructor to initialize the Disjoint Set with n elements
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0); // Initial rank is 0
            parent.add(i); // Each element is its own parent initially
            size.add(1); // Initial size of each set is 1
        }
    }
    
    // Method to find the ultimate parent of a node with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) { // If node is its own parent
            return node;
        }
        // Recursively find the ultimate parent and apply path compression
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    // Union by rank: merges two sets based on their rank
    public void UnionByRank(int u, int v) {
        int ulp_u = findUPar(u); // Find ultimate parent of u
        int ulp_v = findUPar(v); // Find ultimate parent of v
        
        if (ulp_v == ulp_u) return; // Already in the same set
        
        // Attach smaller rank tree under larger rank tree
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            // If ranks are equal, attach one under the other and increase rank
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
    
    // Union by size: merges two sets based on their size
    public void UnionBySize(int u, int v) {
        int ulp_u = findUPar(u); // Find ultimate parent of u
        int ulp_v = findUPar(v); // Find ultimate parent of v
        
        if (ulp_u == ulp_v) return; // Already in the same set
        
        // Attach the smaller set under the larger set
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight; // Source, destination, and weight of the edge
    
    // Constructor
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    // Comparison based on edge weight for sorting
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

// Main solution class
class Solution {
    
    // Function to calculate the weight of the Minimum Spanning Tree (MST)
    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>(); // List to store all edges
        
        // O(V + E): Convert adjacency list to edge list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0); // Adjacent node
                int wt = adj.get(i).get(j).get(1); // Weight of the edge
                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }
        
        // Initialize Disjoint Set
        DisjointSet ds = new DisjointSet(V);
        
        // Sort edges based on weight, O(E log E)
        Collections.sort(edges);
        int mstWt = 0; // Variable to store MST weight
        
        // Iterate over edges and add to MST if they don't form a cycle
        for (Edge edge : edges) {
            int wt = edge.weight;
            int u = edge.src;
            int v = edge.dest;
            
            // Check if adding this edge forms a cycle
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt; // Add edge weight to MST
                ds.UnionBySize(u, v); // Merge the sets
            }
        }
        
        return mstWt; // Return the total weight of the MST
    }
    
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        // Graph edges as {source, destination, weight}
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Fill adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();
            
            tmp1.add(v);
            tmp1.add(w);
            
            tmp2.add(u);
            tmp2.add(w);
            
            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
        
        // Calculate MST weight and print
        int mstWt = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);
    }
}

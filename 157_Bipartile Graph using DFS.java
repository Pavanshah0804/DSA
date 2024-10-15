import java.util.*;

class Solution {

    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        // Initialize all nodes with uncolored (-1).
        Arrays.fill(color, -1);

        // Try to color each component of the graph.
        for (int i = 0; i < V; i++) {
            // If node is not colored, run DFS.
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) return false;
            }
        }
        return true;
    }

    public static boolean dfs(int node, int col, int[][] graph, int[] color) {
        //Color the current node.
        color[node] = col;
        
        //Traverse through all the adjacentNode.
        for (int adjacentNode : graph[node]) {
             // If adjacent node is not colored, recurse to color it with the opposite color
            if (color[adjacentNode] == -1) {
                if (!dfs(adjacentNode, 1 - col, graph, color)) {
                    return false;
                }
            }
            // If adjacent node is already colored and has the same color as the current node, it's not bipartite
            else if (color[adjacentNode] == col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {1, 3}, 
            {0, 2},    
            {1, 3}, 
            {0, 2}
        };

        boolean result = isBipartite(graph);
        System.out.println("Is the graph bipartite? " + (result ? "Yes" : "No"));
    }
}

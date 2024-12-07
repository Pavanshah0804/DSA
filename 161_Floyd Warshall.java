import java.util.*;

class Solution {
    public static void shortest_distance(int[][] matrix) {
        int n = matrix.length; // Number of vertices in the graph
        
        // Step 1: Replace -1 with a large value (infinity) to signify no path
        // and set the diagonal elements to 0 (distance to itself).
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9); // Use a large number for infinity
                }
                if (i == j) {
                    matrix[i][j] = 0; // Distance to itself is always 0
                }
            }
        }

        // Step 2: Apply the Floyd-Warshall algorithm
        // Iterate through each intermediate vertex `k`
        for (int k = 0; k < n; k++) {
            // Iterate through each pair of vertices `i` and `j`
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Update the shortest distance between `i` and `j` 
                    // by considering paths through vertex `k`
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Step 3: Convert back infinity values to -1 for no path
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1; // No path exists
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4; 
        int[][] matrix = new int[V][V]; 
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = -1;
            }
        }

        matrix[0][1] = 2; 
        matrix[1][0] = 1;
        matrix[1][2] = 3; 
        matrix[3][0] = 3; 
        matrix[3][1] = 5; 
        matrix[3][2] = 4; 

        shortest_distance(matrix);

        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

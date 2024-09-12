import java.util.*;

class Solution{
    public static boolean graphColoring(boolean graph[][],int m,int n){
        int color[]  = new int[n];
        Arrays.fill(color,0);
        if(solve(0,color,m,n,graph))
            return true;
        return false;
    }
    
    public static boolean solve(int node, int []color,int m,int n,boolean [][]graph){
        if(node == n)
            return true;
        for(int i=1;i<=m;i++){
            if(isSafe(node,color,graph,n,i)){
                color[node]  = i;
                if(solve(node+1,color,m,n,graph)) return true;
                color[node] = 0;
            }
        }
        return false;
        
    }
    
    public static boolean isSafe(int node, int []color,boolean [][]graph,int n,int col){
        for(int k=0;k<n;k++){
            if(k!=node && graph[k][node] && color[k] == col)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // Define the number of vertices and the number of colors
        int n = 4; // Number of vertices
        int m = 3; // Number of colors

        // Define the graph as an adjacency matrix
        boolean[][] graph = {
            {false, true, true, true},
            {true, false, true, false},
            {true, true, false, true},
            {true, false, true, false}
        };

        // Check if the graph can be colored with m colors
        if (graphColoring(graph, m, n)) {
            System.out.println("The graph can be colored with " + m + " colors.");
        } else {
            System.out.println("The graph cannot be colored with " + m + " colors.");
        }
    }
}
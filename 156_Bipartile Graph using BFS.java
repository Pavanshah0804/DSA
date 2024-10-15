import java.util.*;

class Solution{
    
    public static boolean isBipartite(int [][]graph){
        int V = graph.length;
        int []color = new int[V];
        
        //Initialize all nodes with uncolored.
        for(int i=0;i<V;i++){
            color[i]=-1;
        }
        
        //Try to color each component of the graph
        for(int i=0;i<V;i++){
            //If node is not colored run BFS.
            if(color[i]==-1){
                if(!check(i,graph,color)) return false;
            }
        }
        return true;
    }
    
    public static boolean check(int start,int [][]graph, int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; // Start node with 0 color.
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int adjacentNode : graph[node]){
                if(color[adjacentNode] == -1){ // If the adjacentNode is uncolored.
                    color[adjacentNode] = 1-color[node]; //Assign alternate color.
                    q.add(adjacentNode); // Add the adjacentNode to the queue.
                }
                else if(color[adjacentNode] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String []args){
        int[][] graph = {
            {1, 2, 3}, 
            {0, 2},    
            {0, 1, 3}, 
            {0, 2}     
        };
        
        boolean result = isBipartite(graph);
        System.out.println("Is the graph bipartite? " + result);
    }
}
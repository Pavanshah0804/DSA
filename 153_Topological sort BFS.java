import java.util.*;

class Solution{
    public static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int indegree[] = new int[V];
        
        //Calculate indegree for each vertex.
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        //Queue to store vertices with indegree of 0.
        Queue<Integer> q = new LinkedList<>();
        
        //Add all vertices with indegree 0 to queue.
        for(int i=0;i<V;i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int[] topo = new int[V];
        int i = 0; // Index for the topological order array
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node; // add vertex to topological order.
            
            //For each neighbour of current node reduce its degree.
            for(int it: adj.get(node)){
                indegree[it]--;
            
                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }
    
    public static void main(String []args){
        int V = 6;

        // Create adjacency list for the directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding directed edges (u -> v) in the graph
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Call topoSort function and get the result
        int[] topoOrder = topoSort(V, adj);

        System.out.println("Topological Sort Order:");
        for (int node : topoOrder) {
            System.out.print(node + " ");
        }
    }
}
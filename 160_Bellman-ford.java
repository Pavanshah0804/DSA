import java.util.*;

class Solution{
    public static int[] bellman_ford(int V,ArrayList<ArrayList<Integer>> edges, int src){
        // Initialize the distance array with a very large value (infinity)
        int []dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)(1e8);
        }
        // Initialize the distance array with a very large value (infinity)
        dist[src] = 0;
        
        //Relax all edges V-1 times
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                 // If the source vertex has been relaxed and a shorter path is found, update the distance
                if(dist[u] != 1e8 && dist[u] + wt <dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // Perform an additional relaxation to detect negative weight cycles
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            // If a shorter path is found in the nth iteration, a negative weight cycle exists
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1; // Indicate the presence of a negative weight cycle
                return temp;
            }
        }

        // Return the array of distances from the source to all vertices
        return dist;
    }

    public static void main(String []args){
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }   
        };

        int[] dist = bellman_ford(V, edges, S);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
    }
}
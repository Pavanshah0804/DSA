import java.util.*;

class Solution {
    public static ArrayList<Integer> bfsOfGraph(int V, 
    ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList < Integer > bfs = new ArrayList <> ();
        boolean visited[] = new boolean[V];
        Queue <Integer> q = new LinkedList <> ();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it: adj.get(node)) {
                if(visited[it] == false) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
    
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
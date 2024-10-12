import java.util.*;

class Solution{
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V+1];
        visited[0] = true;
        
        ArrayList<Integer> ls = new ArrayList<Integer>();
        dfs(0,visited,ls,adj);
        return ls;
    }
    
    public static void dfs(int node, boolean[] visited, ArrayList<Integer> ls,ArrayList<ArrayList<Integer>> adj){
        //marking current node as visited
        visited[node] = true;
        ls.add(node);
        
        //getting neighbour nodes
        for(Integer it: adj.get(node)){
            if(visited[it] == false){
                dfs(it,visited,ls,adj);
            }
        }
    }
    
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList <> ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        
        ArrayList <Integer> ans = dfsOfGraph(5, adj);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
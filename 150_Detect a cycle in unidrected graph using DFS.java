import java.util.*;

class Node{
    int first;
    int second;
    
    public Node(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution{
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean []visited = new boolean[V];
        
        //Initialize all nodes to unvisited.
        for(int i=0;i<V;i++){
            visited[i] = false;
        }
        
        //Traverse all the nodes.
        for(int i=0;i<V;i++){
            //If node has not been visited check cycle from that node.
            if(visited[i] == false){
                //If a cycle is detected return true.
                if(checkCycle(i,V,adj,visited)) return true;
            }
        }
        return false;
    }
    
    public static boolean checkCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean []visited){
        //Mark the source node as visited.
        visited[node] = true;
        
       // Iterate over all the adjacent nodes of the current node.
        for (int adjacentNode : adj.get(node)) {
            // If an adjacent node hasn't been visited yet, recursively check it.
            if (!visited[adjacentNode]) {
                // If a cycle is detected in the recursive call, return true.
                if (checkCycle(adjacentNode, node, adj, visited)) return true;
            }
            // If the adjacent node has been visited and it is not the parent node, a cycle is detected.
            else if (adjacentNode != parent) {
                return true;
            }
        }
        // No cycle found from this path, return false.
        return false;
    }
    
    public static void main(String []args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(2).add(5);
        adj.get(5).add(2);
        adj.get(5).add(7);
        adj.get(7).add(5);
        adj.get(3).add(6);
        adj.get(6).add(3);
        adj.get(6).add(7);
        adj.get(7).add(6);
        
        boolean ans = isCycle(8, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");
    }
}
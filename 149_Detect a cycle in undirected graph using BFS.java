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
                if(checkForCycle(i,V,adj,visited)) return true;
            }
        }
        return false;
    }
    
    public static boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean []visited){
        //Mark the source node as visited.
        visited[src] = true;
        
        //Queue for BFS to store current node and its parent.
        Queue<Node> q = new LinkedList<>();
        
        //Add the source node with parent as -1.
        q.add(new Node(src,-1));
        
        while(!q.isEmpty()){
            //Get the current node and its parent from the queue.
            int node = q.peek().first;
            int parent = q.peek().second;
            
            q.remove(); // remove the processed node.
            
            //Check all the adjacent nodes of the current node.
            for(int adjacentNode : adj.get(node)){
                //If adjacent node has not been visited mark it and add it in queue.
                if(visited[adjacentNode] == false){
                    visited[adjacentNode] = true;
                    q.add(new Node(adjacentNode,node));
                }
                //If adjacenet node is visited and it's not the parent, a cycle is found.
                else if(parent!=adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String []args){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                adj.add(new ArrayList < > ());
            }
            adj.get(1).add(2);
            adj.get(2).add(1);
            adj.get(2).add(3);
            adj.get(3).add(2);
                
            boolean ans = isCycle(4, adj);
            if (ans)
                System.out.println("1");    
            else
                System.out.println("0");
    }
}
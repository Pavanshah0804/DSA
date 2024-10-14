import java.util.*;

class Solution{
    
    private static void dfs(int node, int visited[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        //Mark the current node as visited.
        visited[node] = 1;
        
        //Recur for all the verticess and adjacent to this vertex.
        for(int it: adj.get(node)){
            if(visited[it] == 0){ // If the adjacent node is not visited
                dfs(it,visited,st,adj); // perform DFS on unvisited node.
            }
        }
        
        //Push current node to the stack after all adjacent nodes are processed
        st.push(node);
    }
    
    public static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int visited[] = new int [V];
        Stack<Integer> st = new Stack<Integer>();
        
        //Traverse all the nodes, perform DFS if node is univisted
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,st,adj); // Call DFS for unvisited nodes.
            }
        }
        
        int ans[] = new int[V];
        int i=0;
        
        //pop all elements from the stack to get topological order.
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
    
    public static void main(String []args){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=6;
        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(arr);
        }
        
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        int res[] = topoSort(6, adj);
   
        System.out.println("Toposort of the given graph is:" );
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
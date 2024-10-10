import java.util.*;

class Node{
    public int val;
    public List<Node> neighbors;
    
    Node(int val){
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

class Solution{
    static Map<Node,Node> map = new HashMap<>();
    
    public static Node cloneGraph(Node node){
        if(node == null) return null;
        
        //If node is already cloned, return the clone from the map.
        if(map.containsKey(node)) return map.get(node);
        
        //Create a new node for the clone.
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        
        //clone all the neighbors recursively.
        for(Node neighbour : node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbour));
        }
        return newNode;
    }
    
    public static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        System.out.print("Node " + node.val + " with neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();
        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
        
    }
    
    public static void main(String []args){
        
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.addAll(Arrays.asList(node2, node4)); 
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));
        
        Node clonedGraph = cloneGraph(node1);
        
        System.out.println("Original Graph:");
        printGraph(node1, new HashSet<>());
        System.out.println("Cloned Graph:");
        printGraph(clonedGraph, new HashSet<>());
    }
}
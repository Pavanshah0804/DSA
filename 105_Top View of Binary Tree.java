import java.util.*;
import java.util.AbstractMap.SimpleEntry;

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution{
    public static List<Integer> topView (Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<SimpleEntry<Node,Integer>> q = new LinkedList<>();
        q.add(new SimpleEntry<>(root,0));
        
        while(!q.isEmpty()){
            SimpleEntry<Node,Integer> pair = q.remove();
            Node node = pair.getKey();
            int line = pair.getValue();
            
            if(!map.containsKey(line)){
                map.put(line,node.data);
            }
            
            if(node.left != null){
                q.add(new SimpleEntry<>(node.left,line-1));
            }
            if(node.right != null){
                q.add(new SimpleEntry<>(node.right, line+1));
            }
            
        }
        
        for(int value : map.values()){
            ans.add(value);
        }
        return ans;
    }
    
    public static void main(String []args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<Integer> topView = topView(root);

        System.out.println("Vertical Traversal: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
}
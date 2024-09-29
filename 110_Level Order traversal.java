import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int d){
        data = d;
        left = right = null;
    }
}

class Solution{
    
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0;i<size;i++){
                Node node = q.poll();
                level.add(node.data);
                
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
    
    static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    
    public static void main(String []args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        
        
        // Perform level-order traversal
        List<List<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal of Tree:");

        for (List<Integer> level : result) {
            printList(level);
        }
    }
}
//Iterative approach
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node next;
    
    Node(int d){
        data = d;
        left = right = next = null;
    }
}

class Solution{
    
    public static void connect(Node root){
        if(root == null ) return;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            
            for(int i =0;i<size;i++){
                Node current = q.poll();
                
                //link previous nodes next right to current node.
                if(prev!=null) {
                    prev.next = current;
                }
                
                prev = current;
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
            }
            
            //last Node's next should be null
            if(prev!=null){
                prev.next = null;
            }
        }
    }
    
    public static void printLevelOrder(Node root) {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " -> " + (current.next != null ? current.next.data : "null") + " | ");
            current = current.next;
        }
        System.out.println();
        if (root.left != null) printLevelOrder(root.left);
    }
    
    public static void main(String []args){
        
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        
        connect(node);

        System.out.println("Connected nodes at the same level:");
        printLevelOrder(node);
    }
}

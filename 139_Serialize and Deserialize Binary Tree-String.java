import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    Node(int d){
        this.data = d;
        left = right = null;
    }
}

class Solution{
    public static String serialize(Node root){
        if(root == null) return "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            
            if(node == null){
                res.append("# ");
                continue;
            }
            res.append(node.data+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return res.toString();
    }
    
    public static Node deserialize(String str){
        if(str == "") return null;
        
        Queue<Node> q = new LinkedList<>();
        String[] values = str.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.offer(root);
        
        for(int i=1;i<values.length;i++){
            Node parent = q.poll();
            
            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            
            if(!values[++i].equals("#")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
    
    public static void inorder(Node root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static void main(String []args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.print("Orignal Tree: ");
        inorder(root);
        System.out.println();

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        Node deserialized = deserialize(serialized);
        System.out.print("Tree after deserialization: ");
        inorder(deserialized);
        System.out.println();
    }
}
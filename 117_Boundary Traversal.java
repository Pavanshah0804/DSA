import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    Node(int d){
        data = d;
        left = right = null;
    }
}

class Solution{
    
    public static ArrayList<Integer> Boundary(Node node){
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(node == null )return res;
        
        if(!isLeaf(node)){
            res.add(node.data);
        }
        
        addLeftBoundaries(node, res);
        addLeaves(node,res);
        addRightBoundaries(node, res);
        
        return res;
    }
    
    public static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    
    public static void addLeftBoundaries(Node node, ArrayList<Integer> res){
        Node curr = node.left;
        
        while(curr!=null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            
            if(curr.left!=null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }
    
    public static void addRightBoundaries(Node node, ArrayList<Integer> res){
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            
            if(curr.right!=null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }
    
    public static void addLeaves(Node node, ArrayList<Integer> res){
        if(isLeaf(node)){
            res.add(node.data);
            return;
        }
        
        if(node.left!=null){
            addLeaves(node.left,res);
        }
        if(node.right!=null){
            addLeaves(node.right,res);
        }
    }
    
    public static void main(String []args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> result = Boundary(root);

        System.out.print("Boundary Traversal: ");
        for(int ans : result){
            System.out.print(ans+" ");
        }
    }
}
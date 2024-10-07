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
    
    public static boolean findTarget(Node root,int k){
        if(root == null) return false;
        
        //left iterator for inorder traversal
        BSTIterator l = new BSTIterator(root,false);
        //right iterator for inorder traversal
        BSTIterator r = new BSTIterator(root,true);
        
        int i = l.next();//smallest value
        int j = r.next();//largest value
        
        while(i<j){
            if(i+j == k) return true;
            else if(i+j < k) i = l.next();
            else j = r.next();
        }
        
        return false;
    }
    
    public static class BSTIterator{
        private Stack<Node> st = new Stack<>();
        boolean reverse = true;
        
        public BSTIterator(Node node, boolean isReverse){
            reverse = isReverse;
            pushAll(node);
        }
        
        public boolean hasNext(){
            return !st.isEmpty();
        }
        
        public int next(){
            Node tempNode = st.pop();
            if(reverse == false){
                //For Inorder, go to right subtree.
                pushAll(tempNode.right);
            }
            else {
                //For Inorder, go to left subtree.
                pushAll(tempNode.left);
            }
            return tempNode.data;
        }
        
        private void pushAll(Node node){
            while(node != null){
                st.push(node);
                if(reverse) node = node.right; // go to the right if reverse.
                else node = node.left; // go to the left if not reverse.
            }
        }
    }    
    
    public static Node insert(Node root,int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.data){
            root.left = insert(root.left,key);
        }
        else if(key > root.data){
            root.right = insert(root.right,key);
        }
        return root;
    }
    
    public static void main(String []args){
        Node root = null;
        
        int []values = { 5,6,7,2,3,4 };
        for(int value: values){
            root = insert(root,value);
        }
        
        int target = 90;
        boolean ans = findTarget(root, target);
        System.out.println("Target found: " + ans);  // Output result
    }
}
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
    
    public static Node sortedArrayToBST(int []nums){
        if(nums.length == 0) return null;
        
        return constructTreeFromArray(nums,0,nums.length - 1);
    }
    
    public static Node constructTreeFromArray(int []arr,int left,int right){
        if(left>right) return null;
        
        int midpoint = left + (right-left)/2;
        
        Node node = new Node(arr[midpoint]);
        node.left = constructTreeFromArray(arr,left,midpoint-1);
        node.right = constructTreeFromArray(arr,midpoint+1,right);
        
        return node;
    }
    
    public static void printTree(Node node){
        if(node == null) return;
        
        System.out.print(node.data+" ");
        printTree(node.left);
        printTree(node.right);
    }
    
    public static void main(String []args){
        int []arr = {-10,-5,-3,0,5,8,9};
        Node node = sortedArrayToBST(arr);
        
        printTree(node);
        
    }
}
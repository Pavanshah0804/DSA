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
    public static int floor(Node root, int key){
        int floor = -1;
        while(root!=null){
            if(root.data == key){
                floor = root.data;
                return floor;
            }
            else if(key > root.data){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }
    
    public static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }
    
    public static void main(String []args){
        Node root = null;

        int[] values = { 2,81,42,87,66,90,45 };
        for (int value : values) {
            root = insert(root, value);
        }
        int floor = floor(root,84);
        if(floor!=-1){
            System.out.print("floor of given value is "+floor);
        }
    }
}
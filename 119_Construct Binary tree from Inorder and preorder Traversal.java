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
    
    public static Node buildTree(int []inorder,int []preorder){
        Map<Integer,Integer> inMap = new HashMap<>();
        
        // Populate the map with indices of elements in the inorder traversal
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        
        //Call private helper funciton to build tree recursively.
        Node root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        
        return root;
    }
    
    private static Node buildTree(int []preorder,int preStart,int preEnd,int []inorder,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;
        
        //Create root with currrent index of preorder.
        Node root = new Node(preorder[preStart]);
        
        //Find the index of current root in inorder traversal.
        int inRoot = inMap.get(root.data);
        
        //Elements in the left subtree.
        int numsLeft = inRoot-inStart;
        
        
        root.left = buildTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,inMap);
        root.right = buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,inMap);
        
        return root;
    }
    
    public static void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }
    
    public static void main(String []args){
        int []inorder = {9, 3, 15, 20, 7};
        int []preorder = {3, 9, 20, 15, 7};
        
        Node root = buildTree(inorder, preorder);

        // Print the tree using in-order traversal
        System.out.print("Inorder traversal of the constructed tree: ");
        printInOrder(root);
        
    }
}
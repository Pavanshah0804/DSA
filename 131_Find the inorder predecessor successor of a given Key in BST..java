import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        pre[0] = null;
        suc[0] = null;

        Node current = root;
        
        // Find Predecessor
        while (current != null) {
            if (key > current.data) {
                pre[0] = current; // Possible predecessor
                current = current.right;
            } else {
                current = current.left;
            }
        }

        current = root;

        // Find Successor
        while (current != null) {
            if (key < current.data) {
                suc[0] = current; // Possible successor
                current = current.left;
            } else {
                current = current.right;
            }
        }

    }

    public static void main(String[] args) {
        Node node = new Node(8);
        node.left = new Node(1);
        node.left.right = new Node(4);
        node.left.right.left = new Node(3);

        node.right = new Node(9);
        node.right.right = new Node(10);

        Node[] pre = new Node[1]; 
        Node[] suc = new Node[1];  

        findPreSuc(node, pre, suc, 8);
        
         if (pre[0] != null) {
            System.out.println("Predecessor is: " + pre[0].data);
        } else {
            System.out.println("No Predecessor");
        }
        
        if (suc[0] != null) {
            System.out.println("Successor is: " + suc[0].data);
        } else {
            System.out.println("No Successor");
        }
    }
}

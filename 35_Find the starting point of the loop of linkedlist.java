import java.util.*;

class ListNode {
    int val;
    ListNode next;      

    ListNode(int val, ListNode next1) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
        this.next = next;
    }
}

class LinkedListLoopDetection {
   
    public static ListNode firstNode(ListNode head) {
        
        ListNode slow = head;  
        ListNode fast = head;  
    
        while (fast != null && fast.next != null) {
            slow = slow.next;        
            fast = fast.next.next;  
    
            if (slow == fast) {
                slow = head; 
                while (slow != fast) {
                    slow = slow.next;  
                    fast = fast.next;  
                }
                return slow;  
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        // Create a sample linked list with a loop
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        node5.next = node2;

        ListNode head = node1;

        ListNode loopStartNode = firstNode(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.val);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a; // Will be null if there is no intersection
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Total nodes in the first list including intersection
        int m = sc.nextInt();  // Total nodes in the second list including intersection
        int skipA = sc.nextInt();  // Nodes before the intersection in list A
        int skipB = sc.nextInt();  // Nodes before the intersection in list B

        ListNode dummyHead = new ListNode(-1);  // Dummy head for first list
        ListNode dummyHead1 = new ListNode(-1); // Dummy head for second list

        ListNode current = dummyHead;  // Pointer to build the first list
        for (int i = 0; i < skipA; i++) {  // Building the initial part of the first list
            int val = sc.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }

        ListNode current1 = dummyHead1;  // Pointer to build the second list
        for (int i = 0; i < skipB; i++) {  // Building the initial part of the second list
            int val = sc.nextInt();
            current1.next = new ListNode(val);
            current1 = current1.next;
        }

        // Creating the intersection part
        ListNode intersectionStart = null;
        if (n > skipA && m > skipB) {  // Ensure there's room for an intersection
            int intersectionNodes = sc.nextInt();  // Number of nodes in the intersection part
            if (intersectionNodes > 0) {
                int val = sc.nextInt();  // First node of the intersection
                intersectionStart = new ListNode(val);
                current.next = intersectionStart;  // Linking the first list to the intersection
                current1.next = intersectionStart; // Linking the second list to the intersection
                
                // Building the remaining nodes of the intersection
                ListNode intersectionCurrent = intersectionStart;
                for (int i = 1; i < intersectionNodes; i++) {
                    val = sc.nextInt();
                    intersectionCurrent.next = new ListNode(val);
                    intersectionCurrent = intersectionCurrent.next;
                }
            }
        }

        ListNode list1 = dummyHead.next;
        sol.printList(list1);  // Printing the first list
        ListNode list2 = dummyHead1.next;
        sol.printList(list2);  // Printing the second list

        ListNode intersection = sol.getIntersectionNode(list1, list2);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}

Input: 
5 6 2 3
1 2
3 4 5
2
10 20


import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution{
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    
    public void printList(ListNode head){
        ListNode front = head;
        while(front != null){
            System.out.print(front.val+" ");
            front = front.next;
        }
        System.out.println();
    }
    
    public static void main(String []args){
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        
        int n= sc.nextInt();
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }
        
        ListNode head = dummyHead.next;
        sol.printList(head);
        
        ListNode reverseHead = sol.reverseList(head);
        System.out.println("Reversed Linked list: ");
        sol.printList(reverseHead);
    }
}
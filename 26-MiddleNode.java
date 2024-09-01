import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution{
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String []args){
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }
        
        ListNode head = dummyHead.next;
        sol.printList(head);
        
        ListNode middle = sol.middleNode(head);
        System.out.println("The middle node value is: " + middle.val);
        
    }
}
import java.util.*;

class ListNode {
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
    public void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(" "+temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k ==1){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode current = dummy, nex = dummy, pre = dummy;
        int count = 0;
        
        while(current.next!=null){
            current = current.next;
            count++;
        }
        while(count>=k){
            current = pre.next;
            nex = current.next;
        
            for(int i=1;i<k;i++){
                current.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = current.next;
            }
            pre = current;
            count -= k;
        }
        return dummy.next;
    }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }
        
        ListNode head = dummyHead.next;
        sol.printList(head);
        
        ListNode reverseKgroup = sol.reverseKGroup(head, k);
        sol.printList(reverseKgroup);
    }
}
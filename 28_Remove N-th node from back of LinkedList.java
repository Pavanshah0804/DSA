import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    
    ListNode(){};
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
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public ListNode removeNthFromEnd(ListNode head,int k){
            if(head == null)
                return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            
            for(int i=0;i<=k;i++){
                fast = fast.next;
            }
            while(fast!=null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
    }
    
    public static void main(String []args){
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
    
        ListNode newLinkedList = sol.removeNthFromEnd(head,k);
        System.out.println("New Linked List: ");
        sol.printList(newLinkedList);
    }
}
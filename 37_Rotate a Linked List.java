import java.util.Scanner;

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
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null || k==0)
            return head;
        ListNode curr= head;
        int len = 1 ;
        while(curr.next != null){
            len++;
            curr = curr.next;
        }
        
        curr.next = head;
        k= len - k%len;
        while(k-- > 0){
            curr = curr.next;
        }
        
        head = curr.next;
        curr.next = null;
        
        return head;
    }
    
    public void printList(ListNode head){
        ListNode temp= head;
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
        
        ListNode RotateList = sol.rotateRight(head,k);
        System.out.println("Rotated list: after "+k+" iteration.");
        sol.printList(RotateList);
    }
}
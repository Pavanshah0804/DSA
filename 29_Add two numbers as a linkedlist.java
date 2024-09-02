import java.util.*;

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
    
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int sum = carry;
        
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
        }
        return dummy.next;
    }
    
    public static void main(String []args){
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyHead1 = new ListNode(-1);
    
        ListNode current = dummyHead;
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }
    
        ListNode current1 = dummyHead1;
        for(int i=0;i<m;i++){
            int val = sc.nextInt();
            current1.next = new ListNode(val);
            current1 = current1.next;
        }
        
        ListNode list1 = dummyHead.next;
        sol.printList(list1);
        ListNode list2 = dummyHead1.next;
        sol.printList(list2);
    
        ListNode Merge = sol.addTwoNumbers(list1,list2);
        System.out.println("Addition of two linked list: ");
        sol.printList(Merge);
    }
}
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
    
    public ListNode mergeTwoSortedList(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val>l2.val){
            ListNode swap = l1;
            l1 = l2;
            l2 = swap;
        }
        
        ListNode result = l1;// l1 always smaller
        while(l1!=null && l2!= null){
            ListNode temp = null;
            while(l1!=null && l1.val<=l2.val){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
        
            ListNode swap = l1;
            l1 = l2;
            l2 = swap;
        }
        return result;
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
    
        ListNode Merge = sol.mergeTwoSortedList(list1,list2);
        System.out.println("Merged sorted linked list: ");
        sol.printList(Merge);
    }
}
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reversedList(ListNode head){
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
    public boolean isPalindrome(ListNode head) {
        if(head == null||head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next !=null ){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead= reversedList(slow.next); 
        ListNode first = head;
        ListNode second = newHead;
        while(second != null){
            if(first.val != second.val){
            reversedList(newHead);
            return false;
        }
        second = second.next;
        first = first.next;
        }
    reversedList(newHead);
    return true;
    }
    
    public void printList(ListNode head){
        ListNode front = head;
        while(front != null){
            System.out.print(front.val + " ");
            front = front.next;
        }
        System.out.println();
    }
    
     public static void main(String[] args){
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
        
        sol.isPalindrome(head);
        System.out.println("Given LinkedList is Palindrome : "+sol.isPalindrome(head));
    }
}
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
    
    public void deleteNode(ListNode node){
        if(node == null)
            return;
        node.val=node.next.val;
        node.next = node.next.next;
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
        
        
        ListNode temp = dummyHead.next;
        for(int i=1;i<k;i++){
            temp = temp.next;
        }
        
        sol.deleteNode(temp);
        System.out.println("New Linked List: ");
        sol.printList(head);
    }
}
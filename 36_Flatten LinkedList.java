/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class Solution{
    ListNode mergeTwoLists(ListNode a, ListNode b){
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        
        while(a!=null && b!=null){
            if(a.data<b.data ){
                temp.bottom = a;
                a = a.bottom;
                temp = temp.bottom;
            }
            else{
                temp.bottom = b;
                b = b.bottom;
                temp = temp.bottom;
            }
        }
        
        if(a!=null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;
        
    ListNode flatten(ListNode root){
        if(root == null || root.next==null){
            return root;
        }
        root.next = flatten(root.next);
        root = mergeTwoLists(root, root.next);
        return root;
    }
}
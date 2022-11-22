/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = null, prev = null;
        int carry = 0;
        
        // l1 = reverse(l1); l2 = reverse(l2);
        
        while(l1 != null || l2 != null){
            
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            
            carry = (sum >= 10) ? 1 : 0;
            
            ListNode node = new ListNode(sum % 10);
            
            if(head == null){
                head = node;
                prev = node;
            }
            else{
                prev.next = node;
                prev = prev.next;
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) prev.next = new ListNode(carry);
        
        // head = reverse(head);
        
        return head;
    }
    private ListNode reverse(ListNode head){
        
        ListNode prev = null, curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
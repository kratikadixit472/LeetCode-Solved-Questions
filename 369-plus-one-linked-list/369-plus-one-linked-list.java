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
    public ListNode plusOne(ListNode head) {
        
        head = reverse(head);
        
        int sum = 0, carry = 1;
        ListNode nhead = null, node = null;
        
        while(head != null){
            sum = carry + head.val;
            
            head = head.next;
            
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            
            ListNode curr = new ListNode(sum);
            
            if(nhead == null) nhead = curr;
            else{
                node.next = curr;
            }
            
            node = curr;
        }
        if(carry > 0){
            node.next = new ListNode(carry);
        }
        
        nhead = reverse(nhead);
        
        return nhead;
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
}
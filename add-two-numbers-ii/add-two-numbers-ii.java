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
    
    private ListNode reverse(ListNode head){
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1 = reverse(l1);
        l2 = reverse(l2);
       
        ListNode head = null, node = null;
        
        int sum = 0, carry = 0;
        
        while(l1 != null || l2 != null){
            
            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            
            if(l1 != null ) l1 = l1.next; 
            if(l2 != null ) l2 = l2.next;
            
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            
            ListNode curr = new ListNode(sum);
            if(head == null){
                head = curr;
            }
            else{
                node.next = curr;
            }
            
            node = curr;
        }
        
        if(carry > 0){
            node.next = new ListNode(carry);
        }
        
        head = reverse(head);
         return head;
    }
}
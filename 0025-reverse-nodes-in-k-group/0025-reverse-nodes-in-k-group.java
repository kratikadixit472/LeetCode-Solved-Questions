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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head, prev = null;
        
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        if(k > len) return head;
        
        curr = head;
        for(int i=0; i<k; i++){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        head.next = reverseKGroup(curr, k);
        return prev;
    }
    
   /* private ListNode reverse(ListNode head, int k, ListNode forw){
        
        if(k == 1 || head.next == null || head == null){
            forw = head.next;
            head.next = null;
            return head;
        }
        
        ListNode newNode = reverse(head.next, k--, forw);
        
        head.next.next = head;
        
        return newNode;
    }*/
}
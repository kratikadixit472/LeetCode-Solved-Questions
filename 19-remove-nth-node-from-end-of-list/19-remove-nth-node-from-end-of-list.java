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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
         if (head == null) {
            return null;
        }
          
        ListNode slow = head, fast = head;
        ListNode pre = null;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
       
       
        while (fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
      
        if (pre == null) {
            return slow.next;
        }
        pre.next = slow.next;
  
        return head;
        
    }
}
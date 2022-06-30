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
    public ListNode deleteNodes(ListNode head, int M, int N) {
        
        ListNode curr = head, prev = null;
        int m = M, n = N;
        
        while(curr != null){
            
            m = M; n = N;
            
            while(curr != null && m-- > 0){
               prev = curr;
               curr = curr.next;
            }
            
            while(curr != null && n-- > 0){ 
                curr = curr.next;
            }
             
            prev.next = curr;
        }
        return head;
    }
}
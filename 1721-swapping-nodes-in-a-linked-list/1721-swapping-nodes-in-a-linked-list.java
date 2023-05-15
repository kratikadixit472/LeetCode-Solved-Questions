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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || k <= 0) return head;
        
        int len = 0;
        // System.out.println(len +" " +endLen);
        
        ListNode start = null, end = null, curr = head;
        
        while(curr != null){
            len++;
            if(end != null){
                end = end.next;
            }
            if(len == k){
                start = curr;
                end = head;
            }
            curr = curr.next;
        }
        
        // System.out.println(start.val +" " +end.val);
        
        int tmp = start.val;
        start.val = end.val;
        end.val = tmp;
        
        return head;
    }
}
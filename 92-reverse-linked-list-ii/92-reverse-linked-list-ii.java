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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head == null || head.next == null) return head;
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        
        ListNode node = dummyNode;
        
        for(int i = 0; i < left-1; i++){
            node = node.next;
        }
        
        ListNode curr = node.next, forw = curr.next;
        
        for(int i = 0; i < right - left; i++){
            curr.next = forw.next;
            forw.next = node.next;
            node.next = forw;
            forw = curr.next;
        }
        
        return dummyNode.next;
    }
}
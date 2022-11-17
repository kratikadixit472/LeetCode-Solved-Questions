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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        // ListNode curr = head;
        
        if(head.val == head.next.val){
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
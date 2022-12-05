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
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode notNine = dummyNode;
        
        while(head != null){
            if(head.val != 9){
                notNine = head;
            }
            head = head.next;
        }
        
        notNine.val++;
        notNine = notNine.next;
        
        while(notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }
        
        return (dummyNode.val == 0) ? dummyNode.next : dummyNode;
    }
}
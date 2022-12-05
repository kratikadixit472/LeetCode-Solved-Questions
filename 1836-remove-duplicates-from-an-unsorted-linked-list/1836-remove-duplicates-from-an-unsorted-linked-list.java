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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        
        Map<Integer, Integer> map = new HashMap<>();
       
        ListNode nhead = new ListNode(-1);
        nhead.next = head;
        ListNode curr = head, prev = nhead;
        
        while(curr != null){
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){
            if(map.get(curr.val) > 1){
                prev.next = curr.next;
                curr.next = null;
                curr = prev; 
            }
            prev = curr;
            curr = curr.next;
        }
        return nhead.next;
    }
}
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
        
        Map<Integer, Integer> set = new HashMap<>();
        
        ListNode curr = head;
        while(curr != null){
            set.put(curr.val, set.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        
        curr = head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(curr != null){
            if(set.get(curr.val) > 1){
                // curr.next = curr.next.next;
                prev.next = curr.next;
                curr.next = null;
                curr = prev;
                
            }
            prev = curr;
            curr = curr.next;
            
        }
        return dummy.next;
    }
}
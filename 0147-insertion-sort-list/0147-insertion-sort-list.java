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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = getMid(head);
        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(mid);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode a, ListNode b){
        
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        
        while(a != null && b != null){
            
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            }
            else{
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        curr.next = (a == null) ? b : a;
        return dummyNode.next;
    }
    
    private ListNode getMid(ListNode head){
        
        ListNode prev = null, slow = head, fast = head;
    
        while (fast != null && fast.next != null) {
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }
}
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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
        
        ListNode middle = getMiddle(head);
        ListNode nhead = middle.next;
        middle.next = null;
        
        nhead = reverseList(nhead);
        
        ListNode curr1 = head, curr2 = nhead;
        
        while(curr1 != null && curr2 != null){
            
            ListNode f1 = curr1.next;
            ListNode f2 = curr2.next;
            
            curr1.next = curr2;
            curr2.next = f1;
            
            curr1 = f1;
            curr2 = f2;
        }
    }
    
    private ListNode getMiddle(ListNode head){
        
        if(head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverseList(ListNode head){
        
        if(head == null || head.next == null) return head;
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
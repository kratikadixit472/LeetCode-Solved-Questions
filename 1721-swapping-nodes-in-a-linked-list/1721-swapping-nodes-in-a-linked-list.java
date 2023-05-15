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
        
        int len = getLen(head);
        int endLen = len - k;
        // System.out.println(len +" " +endLen);
        
        ListNode start = head, end = head;
        
        while(k-- > 1 && start != null){
            start = start.next;
        }
        
        while(endLen-- > 0 && end != null){
            end = end.next;
        }
        
        // System.out.println(start.val +" " +end.val);
        
        int tmp = start.val;
        start.val = end.val;
        end.val = tmp;
        
        return head;
    }
    
    private int getLen(ListNode head){
        int len = 0;
        
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
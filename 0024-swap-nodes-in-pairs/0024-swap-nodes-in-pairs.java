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
    public ListNode swapPairs(ListNode head) {
        
        ListNode curr = head, prev = null;
        int cnt = 0;
        
        while(curr != null && curr.next != null){
            ListNode next = curr.next;
            ListNode nnext = curr.next.next;
            if(prev == null){
                head = next;
            }
            else{
                prev.next = next;
            }
            curr.next = nnext;
            next.next = curr;
            prev = curr;
            // if(cnt % 2 != 0){
            //     curr = curr.next;
            // }
            if(curr != null) curr = curr.next;
            cnt++;
        }
        return head;
    }
}
/*
prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            if(cnt % 2 != 0){
                curr = curr.next;
            }*/
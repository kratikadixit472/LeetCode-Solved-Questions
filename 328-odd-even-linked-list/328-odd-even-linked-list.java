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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode curr = head;
    
        ListNode evenDummy = new ListNode(-1);
        ListNode oddDummy = new ListNode(-1);
        
        ListNode even = evenDummy, odd = oddDummy;
        int i = 1;
        
        while(curr != null){
            if(i % 2 == 0){
                even.next = curr;
                even = even.next;
            }
            else{
                odd.next = curr;
                odd = odd.next;
            }
            ListNode forw = curr.next;
            curr.next = null;
            curr = forw;
            i++;
        }
        
        even.next = null;
        odd.next = evenDummy.next;
        
        return oddDummy.next;
    }
}
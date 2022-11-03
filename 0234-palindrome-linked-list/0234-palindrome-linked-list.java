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
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;
        Stack<Integer> st = new Stack<>();
        
        ListNode fast = head, slow = head;
        st.push(slow.val);
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            st.push(slow.val);
        }
        
        st.pop();
        if(fast != null) slow = slow.next;
        
        while(!st.isEmpty()){
            if(slow.val != st.pop()) return false;
            slow = slow.next;
        }
        return true;
    }
    
}
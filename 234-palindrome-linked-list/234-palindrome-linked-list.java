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
        
        int len = length(head);
        
        int i = 0;
        while(head.next != null && i < len / 2){
            
            st.push(head.val);
            head = head.next;
            
            i++;
        }
        if(len % 2 == 1) head = head.next;
        
        while(head != null){
            
            if(st.pop() != head.val) return false;
            head = head.next;
        }
        return true;
    }
    
    private int length(ListNode head){
        
        if(head == null) return 0;
        
        int len = 0;
        
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
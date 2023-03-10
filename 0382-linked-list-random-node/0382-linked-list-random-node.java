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

    ListNode nhead;
    Random random;
    
    public Solution(ListNode head) {
        nhead = head;       
        random = new Random();        
    }
    
    public int getRandom() {
        
        ListNode curr = nhead;
        int node = curr.val;
        for(int i=1; curr.next != null; i++){
            
            curr = curr.next;
            if(random.nextInt(i + 1) == i) node = curr.val;                        
        }
        
        return node;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
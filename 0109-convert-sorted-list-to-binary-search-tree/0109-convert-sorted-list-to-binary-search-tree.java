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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null) return null;
        
        return convertToBST(head, null);
    }
    
    private TreeNode convertToBST(ListNode start, ListNode last){
        
        if(start == last) return null;
        
        ListNode mid = getMid(start, last);
        
        TreeNode root = new TreeNode(mid.val);
        
        root.left = convertToBST(start, mid);
        root.right = convertToBST(mid.next, last);
        
        return root;
    }
    
    private ListNode getMid(ListNode head, ListNode tail){
        
        if(head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head;
        
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
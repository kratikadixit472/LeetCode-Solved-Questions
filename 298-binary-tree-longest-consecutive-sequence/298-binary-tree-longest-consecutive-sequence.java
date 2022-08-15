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
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        
        helper(root, root.val, 1);
        
        return ans;
    }
    
    private void helper(TreeNode root, int prev, int cnt){
        
        if(root == null) return ;
        
        
        if(root.val - prev == 1) {
            System.out.print(root.val + " ");
            cnt++;
        }
        else cnt = 1;
        ans = Math.max(ans, cnt);
        helper(root.left, root.val, cnt);
        helper(root.right, root.val, cnt);
    }
}
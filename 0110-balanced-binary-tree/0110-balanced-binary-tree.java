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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root){
        
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(Math.abs(right - left) > 1){
            res = false;
        }
        
        return 1 + Math.max(right, left);
    }
}
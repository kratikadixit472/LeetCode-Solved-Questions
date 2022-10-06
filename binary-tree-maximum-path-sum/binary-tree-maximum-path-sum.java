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
    
    int maxPathSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        findMaxPathsum(root);
        return maxPathSum;
    }
    
    private int findMaxPathsum(TreeNode root){
        
        if(root == null) return 0;
        
        int left = findMaxPathsum(root.left);
        int right = findMaxPathsum(root.right);
        
        int leftRightRoot = root.val + left + right;
        int left_or_right_root = Math.max(root.val+left, root.val+right);
        int maxSum = Math.max(root.val, left_or_right_root);
        maxPathSum = Math.max(maxPathSum, Math.max(left_or_right_root, Math.max(root.val, leftRightRoot)));
        
        return maxSum;
    }
}
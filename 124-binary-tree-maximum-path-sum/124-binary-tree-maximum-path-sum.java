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
    
    int maxAns = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        maxPathSumFrom(root);
        
        return maxAns;
    }
    
    private int maxPathSumFrom(TreeNode root){
        
        if(root == null) return 0;
        
        int left = maxPathSumFrom(root.left);
        int right = maxPathSumFrom(root.right);
        
        int rootToChildSum = Math.max(Math.max(left, right) + root.val, root.val);
        int subTreeSum = Math.max(root.val + left + right, rootToChildSum);
        maxAns = Math.max(maxAns, subTreeSum);
        
        return rootToChildSum;
    }
}
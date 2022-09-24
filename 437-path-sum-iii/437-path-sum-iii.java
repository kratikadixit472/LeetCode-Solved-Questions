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
    
    int c = (int)(1e9 + 7);
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        
        return getAllPathSum(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int getAllPathSum(TreeNode root, int targetSum, long sum){
        
        if(root == null) return 0;
        
        sum += root.val;
        
        return (((sum == targetSum) ? 1 : 0) + getAllPathSum(root.left, targetSum, sum) + getAllPathSum(root.right, targetSum, sum)) % c;
    }
}
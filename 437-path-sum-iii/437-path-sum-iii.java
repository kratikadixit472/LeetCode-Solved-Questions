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
    
    int c = (int)(1e9);
    
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return 0;
        
        return pathSumFrom(root, 0, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int pathSumFrom(TreeNode root, long currSum, int targetSum){
        
        if(root == null) return 0;
        currSum += root.val;
        
        return (((currSum == targetSum) ? 1 : 0) + pathSumFrom(root.left,currSum , targetSum) + pathSumFrom(root.right, currSum , targetSum)) % c;
        
    }
}
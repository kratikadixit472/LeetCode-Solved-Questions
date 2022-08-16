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
    int ans = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        
        if(root == null) return ans;
        
        if(root.left != null){
            getMinimumDifference(root.left);
        }
        if(prev != null){
            ans = Math.min(ans, (root.val - prev));
        }
        
        prev = root.val;
        
        if(root.right != null){
            getMinimumDifference(root.right);
        }
        
        return ans;
    }
}
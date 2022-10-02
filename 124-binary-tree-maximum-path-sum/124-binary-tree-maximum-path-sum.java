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
    
    int maxPathsum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        getMaxPath(root);
        return maxPathsum;
    }
    
    private int getMaxPath(TreeNode root){
        
        if(root == null) return 0;
        
        int left = getMaxPath(root.left);
        int right = getMaxPath(root.right);
        
        int rootLeftRight = root.val + left + right;
        int root_L_R = Math.max(root.val, Math.max(root.val + left, root.val + right));
        maxPathsum = Math.max(maxPathsum, Math.max(root_L_R, rootLeftRight));
        return root_L_R;
    }
}
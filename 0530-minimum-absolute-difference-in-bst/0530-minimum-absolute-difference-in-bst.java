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
    
    TreeNode prev = null;
    int res = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        
        InOrder(root);
        return res;
    }
    
    private void InOrder(TreeNode root){
        
        if(root == null) return;
        
        InOrder(root.left);
        
        if(prev != null){
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        InOrder(root.right);
    }
}
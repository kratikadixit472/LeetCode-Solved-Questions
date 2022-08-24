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
    Integer prev, ans;
    
    public int minDiffInBST(TreeNode root) {
        
        prev = null;
        ans = Integer.MAX_VALUE;
        
        DFS(root);
        return ans;
    }
    
    private void DFS(TreeNode root){
        
        if(root == null) return;
        
        DFS(root.left);
        
        if(prev != null){
            ans = Math.min(ans, root.val - prev);
        }
        prev = root.val;
        
        DFS(root.right);
    }
}
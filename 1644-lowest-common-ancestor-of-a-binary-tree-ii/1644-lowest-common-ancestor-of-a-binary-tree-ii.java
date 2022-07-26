/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode pp = null, qq = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode lcs = LCS(root, p, q);
        
        if(pp != null && qq != null) return lcs;
        
        return null;
    }
    
    private TreeNode LCS(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        
        TreeNode left = LCS(root.left, p, q);
        TreeNode right = LCS(root.right, p, q);
        
        if(root.val == p.val || root.val == q.val) {
            if(root.val == p.val){
                pp = root;
            }
            else qq = root;
            return root;
        }
        
        if(left != null && right != null) return root;
        
        return (left == null) ? right : left;
    }
}
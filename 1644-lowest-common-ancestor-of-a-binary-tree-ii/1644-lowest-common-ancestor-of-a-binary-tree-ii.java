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
    
    boolean pp = false, qq = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode lcs = LCS(root, p, q);
        
        return (pp && qq ) ? lcs : null;

    }
    
    private TreeNode LCS(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        
        TreeNode left = LCS(root.left, p, q);
        TreeNode right = LCS(root.right, p, q);
        
        if(root.val == p.val || root.val == q.val) {
            if(root.val == p.val){
                pp = true;
            }
            else qq = true;
            return root;
        }
        
        return (left == null) ? right : (right == null) ? left : root;
    }
}
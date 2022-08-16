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
    
    int longCons = 0;
    
    public int longestConsecutive(TreeNode root) {
        
        longestPath(root);
        
        return longCons;
    }
    
    private int[] longestPath(TreeNode root){
        if(root == null) return new int[2];
        
        int inc = 1, dec = 1;
        if(root.left != null){
            int[] left = longestPath(root.left);
            if(root.val == root.left.val + 1){
                inc = left[0] + 1;
            }
            if(root.val == root.left.val - 1){
                dec = left[1] + 1;
            }
        }
        if(root.right != null){
            int[] right = longestPath(root.right);
            if(root.val == root.right.val + 1){
                inc = Math.max(inc, right[0] + 1);
            }
            if(root.val == root.right.val - 1){
                dec = Math.max(dec, right[1] + 1);
            }
        }
        longCons = Math.max(longCons, inc + dec - 1);
        
        return new int[]{inc, dec};
    }
}
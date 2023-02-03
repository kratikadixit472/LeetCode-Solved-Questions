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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        getdiameterOfBinaryTree(root);
        return res;
    }
    
    private int getdiameterOfBinaryTree(TreeNode root){
        
        if(root == null) return 0;
        
        int left = getdiameterOfBinaryTree(root.left);
        int right = getdiameterOfBinaryTree(root.right);
        
        res = Math.max(res, right + left);
        return 1 + Math.max(left, right);
    }
}
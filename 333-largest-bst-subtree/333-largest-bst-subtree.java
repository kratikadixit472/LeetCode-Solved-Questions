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
    
    public int largestBSTSubtree(TreeNode root) {
        
        if(root == null) return 0;
        
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return countNodes(root);
        }
        
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private int countNodes(TreeNode root){
        
        if(root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private boolean isBST(TreeNode root, int min, int max){
        
        if(root == null) return true;
        
        if(root.val <= min || root.val >= max) return false;
        
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
        
    }
}
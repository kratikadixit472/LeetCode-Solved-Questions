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
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int lh = 1, rh = 1;
        TreeNode left = root.left, right = root.right;
        
        while(left != null){
            left = left.left;
            lh++;
        }
        while(right != null){
            right = right.right;
            rh++;
        }
        if(lh == rh) return (int)(Math.pow(2, lh)) - 1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
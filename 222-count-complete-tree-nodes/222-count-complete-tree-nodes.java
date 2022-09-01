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
        
        int left_level = 1, right_level = 1;
        
        TreeNode lft = root.left, rgt = root.right;
        
        while(lft != null){
            lft = lft.right;
            left_level++;
        }
        while(rgt != null){
            rgt = rgt.right;
            left_level++;
        }
        if(left_level == right_level) return (int)(Math.pow(2, left_level) - 1);
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
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
    int secMin = -1, min = -1;
    public int findSecondMinimumValue(TreeNode root) {
        
        getMinNodes(root);
        return secMin;
    }
    private void getMinNodes(TreeNode root) {
        if(root == null) return;
        if(min == -1 || root.val <= min){
            min = root.val;
        }
        else if(secMin == -1 || root.val < secMin){
            secMin = root.val;
        }
        getMinNodes(root.left);
        getMinNodes(root.right);
    }
}
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        TreeNode curr = root;
        
        curr = DFS(curr, target);

        return curr;
    }
    private TreeNode DFS(TreeNode root, int target){
        if(root == null) return null;
        
        root.left = DFS(root.left, target);
        root.right = DFS(root.right, target);
        
        if(root.left == null &&root.right == null && root.val == target){
            return null;
        }
        return root;
    }
}
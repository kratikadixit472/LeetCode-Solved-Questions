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
    
    
    public TreeNode[] splitBST(TreeNode root, int target) {
        
        if(root == null) return new TreeNode[]{null, null};
    
        else if(root.val <= target){
            TreeNode[] bns = splitBST(root.right, target);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        }
        
        else {
            TreeNode[] bns = splitBST(root.left, target);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }
    }
}
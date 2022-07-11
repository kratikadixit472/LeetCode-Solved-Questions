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
    
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        if(root == null) return ans;
        
        ans.add(root.val);
        leftView(root.left);
        addLeaves(root.left);
        addLeaves(root.right);
        rightView(root.right);
        
        return ans;
    }
    
    private void leftView(TreeNode root){
        
        if(root == null || (root.left == null && root.right == null)) return;
        
        ans.add(root.val);
        if(root.left != null) leftView(root.left);
        else leftView(root.right);
    }
    
    private void addLeaves(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) ans.add(root.val);
        
        addLeaves(root.left);
        addLeaves(root.right);
    }
    
    private void rightView(TreeNode root){
        
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.right != null) rightView(root.right);
        else rightView(root.left);
        
        ans.add(root.val);
    }
}
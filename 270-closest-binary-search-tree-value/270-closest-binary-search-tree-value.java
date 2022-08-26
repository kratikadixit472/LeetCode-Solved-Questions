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
    
    int ans = Integer.MAX_VALUE;
    double diff = Integer.MAX_VALUE;
    
    public int closestValue(TreeNode root, double target) {
        
        if(root == null) return 0;
        
        findClose(root, target);
        return ans;
    }
    
    private void findClose(TreeNode root, double target){
        
        if(Math.abs(target - root.val) < diff){
            // System.out.println(root.val +" "+ Math.abs(target - root.val));
            diff = Math.abs(target - root.val);
            ans = root.val;
        }
        if(root.left != null && root.val > target){
            findClose(root.left, target);
        }
        else if(root.right != null && root.val < target){
            findClose(root.right, target);
        }
        
    }
}
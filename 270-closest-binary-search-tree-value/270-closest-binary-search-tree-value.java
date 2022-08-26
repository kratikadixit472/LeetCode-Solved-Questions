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
    
    public int closestValue(TreeNode root, double target) {
        
        if(root == null) return 0;
        int ans = root.val;
       
        while(root != null){
            
            ans = (Math.abs(target - root.val) < Math.abs(target - ans)) ? root.val : ans;
            
            root = (root.val > target) ? root.left : root.right;
        
        }
        return ans;
    }
}
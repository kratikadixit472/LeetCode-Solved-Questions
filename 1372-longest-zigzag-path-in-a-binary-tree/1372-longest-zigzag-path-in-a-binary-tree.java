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
    int res = Integer.MIN_VALUE;
    
    public int longestZigZag(TreeNode root) {
        
        getMaxVal(root, 0, true);
        getMaxVal(root, 0, false);
                       
        return res;
    }
    
    private void getMaxVal(TreeNode root, int cnt, boolean flag){
        
        if(root == null) return ;
        
        res = Math.max(res, cnt);
        
        if(flag){
            getMaxVal(root.left, cnt+1, false);
            getMaxVal(root.right, 1, true);
        }
        
        else{
            getMaxVal(root.right, cnt+1, true);
            getMaxVal(root.left, 1, false);
        }
    }
}
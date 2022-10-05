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
    
    int left, right;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        countNodes(root, x);
        
        if(left > n / 2 || right > n / 2) return true;
        if(left + right + 1 <= n / 2) return true;
        
        return false;
    }
    
    private int countNodes(TreeNode root, int val){
        
        if(root == null) return 0;
        
        int l = countNodes(root.left, val);
        int r = countNodes(root.right, val);
        
        if(root.val == val){
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}
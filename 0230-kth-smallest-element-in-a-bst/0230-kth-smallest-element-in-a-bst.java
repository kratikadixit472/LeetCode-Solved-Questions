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
    int kth = -1, cnt = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null) return -1;
        kSmallest(root, k);
        return kth;
    }
    private void kSmallest(TreeNode root, int k){
        
        if(root.left != null){
            kthSmallest(root.left, k);
        }
        cnt++;
        
        if(k == cnt) {
            kth = root.val;
            return;
        }
        
        if(root.right != null){
            kthSmallest(root.right, k);
        }
    }
}
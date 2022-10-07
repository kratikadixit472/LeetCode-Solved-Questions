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
    
    TreeNode first = null, sec = null, prev = null;
    
    public void recoverTree(TreeNode root) {
        
        recover(root);
        
        int tmp = first.val;
        first.val = sec.val;
        sec.val = tmp;
    }
    
    private void recover(TreeNode root){
        
        if(root != null){
            
            recover(root.left);
            
            if(prev != null && root.val < prev.val){
                
                if(first == null){
                    first = prev;
                }
                if(root.val < prev.val){
                    sec = root;
                }
            }
            // if(first != null && sec != null) return;
            
            prev = root;
            
            recover(root.right);
        }
    }
}
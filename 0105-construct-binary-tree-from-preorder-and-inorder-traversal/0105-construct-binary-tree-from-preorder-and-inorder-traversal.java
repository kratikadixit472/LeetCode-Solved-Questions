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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n = preorder.length;
        return getTree(0, 0, n-1, preorder, inorder);
    }
    
    private TreeNode getTree(int startPre, int startIn, int endI, int[] pre, int[] in){
        if(startPre > pre.length - 1 || startIn >  endI) return null;
        
        TreeNode root = new TreeNode(pre[startPre]);
        
        int idx = 0;
        
        for(int i = startIn; i <= endI; i++){
            if(pre[startPre] == in[i]){
                idx = i;
            }
        }
        
        root.left = getTree(startPre + 1, startIn, idx - 1, pre, in);
        root.right = getTree(startPre + idx - startIn + 1, idx + 1, endI, pre, in);
        
        return root;
    }
    
}
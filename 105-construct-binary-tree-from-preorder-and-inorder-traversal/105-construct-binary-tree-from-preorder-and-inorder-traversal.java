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
        
        return getTree(0, 0, inorder.length-1, preorder, inorder);
    }
    private TreeNode getTree(int startPre, int startIn, int endIn, int[] preorder, int[] inorder){
        
        if(startPre > preorder.length-1 || startIn > endIn) return null;
        
        TreeNode root = new TreeNode(preorder[startPre]);
        
        int idx = 0;
        
        for(int i = startIn ; i <= endIn; i++){
            if(preorder[startPre] == inorder[i]){
                idx = i;
            }
        }
        // System.out.println(startIn+" "+ endIn);
        root.left = getTree(startPre+1, startIn, idx-1, preorder, inorder);
        root.right = getTree(startPre+idx-startIn + 1, idx+1, endIn, preorder, inorder);
        
        return root;
    }
}
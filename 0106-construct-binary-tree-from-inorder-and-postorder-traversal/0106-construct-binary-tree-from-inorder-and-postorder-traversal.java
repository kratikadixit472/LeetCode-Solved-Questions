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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return f(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }

    private TreeNode f(int[] inorder, int[] postorder, int st, int end, int ind) {
        if(st>end) return null;

        TreeNode node = new TreeNode(postorder[ind]);
        int i = st;
        while(i<=end){
            if(inorder[i] == postorder[ind]) break;
            i++;
        }

        node.right = f(inorder, postorder, i+1, end, ind-1);

        node.left = f(inorder, postorder, st, i-1, ind - (end-i) -1);

        return node;
    }
}
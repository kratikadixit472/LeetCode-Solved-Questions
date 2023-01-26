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
        return tree(0, preorder.length - 1, 0, preorder, inorder);
    }
    
    private TreeNode tree(int pidx, int eidx, int iidx, int[] pre, int[] in){
        
        if(pidx > pre.length - 1 || iidx > eidx) return null;
        
        TreeNode root = new TreeNode(pre[pidx]);
        
        int idx = 0;
        for(int i = iidx; i <= eidx; i++){
            if(pre[pidx] == in[i]){
                idx = i;
            }
        }
        
        root.left = tree(pidx + 1, idx-1, iidx, pre, in);
        root.right = tree(pidx + idx- iidx + 1, eidx, idx+1, pre, in);
        return root;
    }
}
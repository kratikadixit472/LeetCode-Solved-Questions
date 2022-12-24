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
    TreeNode targetNode, rightNext;
    int targetDepth = -1;
    
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        
        if(root == null || u == null) return null;
        
        targetNode = u;
        DFS(root, 0);
        return rightNext;
    }
    
    private void DFS(TreeNode root, int depth){
        if(root == null) return ;
        
        if(root == targetNode){
            targetDepth = depth;
            return;
        }
        
        if(targetDepth == depth){
            if(rightNext == null) rightNext = root;
            return;
        }
        
        DFS(root.left, depth + 1);
        DFS(root.right, depth + 1);
        
    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        DFS(root, 0, ans);
        return ans;
    }
    
    private void DFS(TreeNode root, int level, List<Integer> ans){
        
        if(level == ans.size()) ans.add(root.val);
        
        if(root.right != null) DFS(root.right, level + 1, ans);
        if(root.left != null) DFS(root.left, level + 1, ans);
        
    }
}
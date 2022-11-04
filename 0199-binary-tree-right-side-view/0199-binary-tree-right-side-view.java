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
        
        callDFS(root, ans, 0);
        return ans;
    }
    private void callDFS(TreeNode root, List<Integer> ans, int depth){
        
        if(root == null) return;
        
        if(ans.size() == depth){
            ans.add(root.val);
        }
        
        callDFS(root.right, ans, depth + 1);
        callDFS(root.left, ans, depth + 1);
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        
        if(root == null) return ans;
        getLevelOrder(root, ans, 0);
        return ans;
    }
        
    private void getLevelOrder(TreeNode root, List<List<Integer>> ans, int level){
        
        if(root == null) return;
        if(level == ans.size()){
            ans.add(new ArrayList<>());
        }
        
        ans.get(level).add(root.val);

        if(root.left != null) getLevelOrder(root.left, ans, level + 1);
        if(root.right != null) getLevelOrder(root.right, ans, level + 1);

    }
}
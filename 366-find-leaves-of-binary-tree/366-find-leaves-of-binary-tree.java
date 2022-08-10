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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(true){
            List<Integer> al = new ArrayList<>();
            root = dfs(root,  al);
            ans.add(al);
            if(al.size() == 1 && root  == null) break;
        }
        return ans;
    }
    private TreeNode dfs(TreeNode root, List<Integer> al){
        
        if(root == null) return null;
        
        if(root.left == null && root.right == null) {
            al.add(root.val);
            return null;
        }
         
        if(root.left != null) {
           root.left = dfs(root.left, al);
        }
        if(root.right != null) {
           root.right = dfs(root.right, al);
        }
        
        return root;
    }
}
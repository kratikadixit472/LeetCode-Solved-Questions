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
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        while(root != null){
            List<Integer> al = new ArrayList<>();
            root = DFS(root, al);
            ans.add(al);
        }
        return ans;
    }
    
    private TreeNode DFS(TreeNode root, List<Integer> al){
        if(root == null) return null;
        
        if(root.left == null && root.right == null) {
            al.add(root.val);
            return null;
        }
        
        root.left = DFS(root.left, al);
        root.right = DFS(root.right, al);
        return root;
    }
}
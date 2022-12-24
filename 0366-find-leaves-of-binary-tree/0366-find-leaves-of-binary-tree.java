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
    
    List<List<Integer>> ans;
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        ans = new ArrayList<>();
        if(root == null) return ans;
        
        while(root != null){
            List<Integer> al = new ArrayList<>();
            root = findLevelLeaves(root, al);
            ans.add(al);
        }
        return ans;
    }
    private TreeNode findLevelLeaves(TreeNode root, List<Integer> al) {
        
        if(root == null) return null;
        
        if(root.left == null && root.right == null){
            al.add(root.val);
            return null;
        }
        root.left = findLevelLeaves(root.left, al);
        root.right = findLevelLeaves(root.right, al);
        
        return root;
    }
}
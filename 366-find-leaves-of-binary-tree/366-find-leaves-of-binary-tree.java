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
        
        while(true){
            List<Integer> al = new ArrayList<>();
            root = removeLeaves(root, al);
            ans.add(al);
            if(al.size() == 1 && root == null) break;
        }
        return ans;
    }
    private TreeNode removeLeaves(TreeNode root, List<Integer> al){
        
        if(root == null) return null;
        
        if(root.left == null && root.right == null) {
            al.add(root.val);
            return null;
        }
        
        if(root.left != null) root.left = removeLeaves(root.left, al);
        if(root.right != null) root.right = removeLeaves(root.right, al);
        
        return root;
    }
}
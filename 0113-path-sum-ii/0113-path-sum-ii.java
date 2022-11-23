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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        getPathSum(root, targetSum, new ArrayList<>());
        return ans;
    }
    
    private void getPathSum(TreeNode root, int targetSum, List<Integer> al) {
        
        if(root == null) return;
        
        al.add(root.val);
        
        if(root.left == null && root.right == null && targetSum == root.val) ans.add(new ArrayList<Integer>(al));
        
        else{
            getPathSum(root.left, targetSum - root.val, al);
            getPathSum(root.right, targetSum - root.val, al);
        }
        al.remove(al.size()-1);
    }
}
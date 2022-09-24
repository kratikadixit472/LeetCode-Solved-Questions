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
        
        backtrack(root, new ArrayList<>(), targetSum);
        return ans;
    }
    private void backtrack(TreeNode root, List<Integer> al, int targetSum){
        
        if(root == null) return;
        
        al.add(root.val);
        
        if(root.left == null && root.right == null && targetSum == root.val){
            ans.add(new ArrayList<>(al));
        }
        
        backtrack(root.left, al, targetSum - root.val);
        backtrack(root.right, al, targetSum - root.val);
        al.remove(al.size()-1);
    }
}
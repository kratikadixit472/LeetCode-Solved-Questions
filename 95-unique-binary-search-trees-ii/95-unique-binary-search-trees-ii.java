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
    // List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
        return getAllTrees(1, n);
    }
    private List<TreeNode> getAllTrees(int si, int ei){
        List<TreeNode> result = new ArrayList<>();
        
        if(si > ei) {
            result.add(null);
            return result;
        }
        
        for(int cut = si; cut <= ei; cut++){
             
            List<TreeNode> left = getAllTrees(si, cut-1);
            List<TreeNode> right = getAllTrees(cut+1, ei);
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(cut);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
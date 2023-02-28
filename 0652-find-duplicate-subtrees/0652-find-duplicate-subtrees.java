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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        List<TreeNode> ans = new ArrayList<>();
        
        traverseTree(root, new HashMap<>(), ans);
        return ans;
    }
    private String traverseTree(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
        if(root == null) return "";
        
        String s = "(" + traverseTree(root.left, map, ans) + ")" + root.val + "(" + traverseTree(root.right, map, ans) + ")";
        
        map.put(s, map.getOrDefault(s, 0) + 1);
        
        if(map.get(s) == 2) ans.add(root);
        
        return s;
    }
}
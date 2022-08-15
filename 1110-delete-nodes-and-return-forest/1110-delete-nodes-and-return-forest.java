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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i : to_delete){
            set.add(i);
        }
        
        DFS(root, set, forest);
        
        if(!set.contains(root.val)){
            forest.add(root);
        }
        return forest;
    }
    
    private TreeNode DFS(TreeNode root, Set<Integer> set, List<TreeNode> forest){
        
        if(root == null) return null;
        
        root.left = DFS(root.left, set, forest);
        root.right = DFS(root.right, set, forest);
        
        if(set.contains(root.val)){
            if(root.left != null) forest.add(root.left);
            if(root.right != null) forest.add(root.right);
            
            return null;
        }
        return root;
    }
}
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
        Set<Integer> delete = new HashSet<>();
        
        for(int d : to_delete){
            delete.add(d);
        }
        
        deleteNodes(root, delete, forest);
        
        if(!delete.contains(root.val)) forest.add(root);
        
        return forest;
    }
    private TreeNode deleteNodes(TreeNode root, Set<Integer> delete, List<TreeNode> forest){
        
        if(root == null) return null;
        
        root.left = deleteNodes(root.left, delete, forest);
        root.right = deleteNodes(root.right, delete, forest);
        
        if(delete.contains(root.val)){
            if(root.left != null) forest.add(root.left);
            if(root.right != null) forest.add(root.right);
            
            return null;
        }
        return root;
    }
}
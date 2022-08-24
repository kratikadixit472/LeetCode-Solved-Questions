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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        
        TreeNode LCA = LCA(root, startValue, destValue);
        findPath(LCA, start, startValue);
        findPath(LCA, dest, destValue);
        
        return "U".repeat(start.length()) + dest.toString();
    }
    
    private boolean findPath(TreeNode root, StringBuilder sb, int val){
        
        if(root == null) return false;
        
        if(root.val == val) return true;
        
        sb.append('L');
        if(findPath(root.left, sb, val)){
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('R');
        if(findPath(root.right, sb, val)){
            return true;
        }
        
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
   
    private TreeNode LCA(TreeNode root, int start, int dest){
        
        if(root == null) return null;
        
        if(root.val == start || root.val == dest) return root;
        
        TreeNode left = LCA(root.left, start, dest);
        TreeNode right = LCA(root.right, start, dest);
        
        if(left != null && right != null) return root;
        
        return (left == null) ? right : left;
    }
    
    
    
    
    
    
    
    
    
}
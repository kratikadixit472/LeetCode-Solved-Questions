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
        
        findNode(root, start, startValue);
        findNode(root, dest, destValue);
        
        start.reverse();
        dest.reverse();
        
        while(start.length() > 0 && dest.length() > 0 && start.charAt(0) == dest.charAt(0)){
            start.deleteCharAt(0);
            dest.deleteCharAt(0);
        }
        
        return "U".repeat(start.length()) + dest.toString();
    }
    
    private boolean findNode(TreeNode root, StringBuilder sb, int val){
        
        if(root == null) return false;
        
        if(root.val == val) return true;
        
        if(root.left != null & findNode(root.left, sb, val)){
            sb.append("L");
            return true;
        }
        if(root.right != null & findNode(root.right, sb, val)){
            sb.append("R");
            return true;
        }
        return false;
    }
}
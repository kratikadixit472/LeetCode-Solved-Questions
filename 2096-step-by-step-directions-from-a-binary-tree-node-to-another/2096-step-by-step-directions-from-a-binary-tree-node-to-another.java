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
        
        TreeNode lcs = findLCS(root, startValue, destValue);
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        pathfromLCS(lcs, startValue, start);
        pathfromLCS(lcs, destValue, end);
        
        return "U".repeat(start.length()) + end.toString();
    }
    
    private boolean pathfromLCS(TreeNode root, int val, StringBuilder sb){
        if(root == null) return false;
        if(root.val == val) return true;
        sb.append("L");
        if(pathfromLCS(root.left, val, sb)) return true;
        sb.deleteCharAt(sb.length()-1);
        
        sb.append("R");
        if(pathfromLCS(root.right, val, sb)) return true;
        sb.deleteCharAt(sb.length()-1);
        
        return false;
    }
    private TreeNode findLCS(TreeNode root, int startValue, int destValue){
        if(root == null) return null;
        
        if(root.val == startValue || root.val == destValue) return root;
            
        TreeNode left = findLCS(root.left, startValue, destValue);
        TreeNode right = findLCS(root.right, startValue, destValue);
        
        if(left != null && right != null) return root;
        return (left == null) ? right : left;
    }
}
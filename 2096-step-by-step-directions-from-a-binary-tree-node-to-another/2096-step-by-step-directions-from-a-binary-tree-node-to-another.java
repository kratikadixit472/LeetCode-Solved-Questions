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
        
        StringBuilder ss = new StringBuilder();
        StringBuilder sd = new StringBuilder();
        
        getDir(root, startValue, ss);
        getDir(root, destValue, sd);
        
        ss.reverse();
        sd.reverse();
        
        int i = ss.length(), j = sd.length();
        
        while(ss.length() > 0 && sd.length() > 0 && ss.charAt(0) == sd.charAt(0)){
            ss.deleteCharAt(0);
            sd.deleteCharAt(0);
        }
        String s = ss.toString(), d = sd.toString();
        
        return "U".repeat(s.length()) + d;
    }
    
    private boolean getDir(TreeNode root, int val, StringBuilder sb){
        
        if(root.val == val) return true;
        
        if(root.left != null && getDir(root.left, val, sb)){
            sb.append("L");
            return true;
        }
        
        else if(root.right != null && getDir(root.right, val, sb)){
            sb.append("R");
            return true;
        }
        return false;
    }
}
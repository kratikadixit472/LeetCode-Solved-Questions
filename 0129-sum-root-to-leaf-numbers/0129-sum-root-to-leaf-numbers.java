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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        backtract(root, new StringBuilder());
        return sum;
    }
    
    private void backtract(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val);
        
        if(root.left == null && root.right == null){
            System.out.print(sb+" ");
            sum += Integer.valueOf(sb.toString());
        }
        
        
        backtract(root.left, sb);
        backtract(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
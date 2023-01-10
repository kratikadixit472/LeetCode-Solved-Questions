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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateMaxSum(root);
        return maxSum;
    }
    private int calculateMaxSum(TreeNode root){
        if(root == null) return 0;

        int left = calculateMaxSum(root.left);
        int right = calculateMaxSum(root.right);

        int leftRight = root.val + left + right;
        int leftRootRight =  Math.max(root.val + left, root.val + right);
        int max = Math.max(root.val, leftRootRight);
        maxSum = Math.max(maxSum, Math.max(max, leftRight));
        return max;
    }
}
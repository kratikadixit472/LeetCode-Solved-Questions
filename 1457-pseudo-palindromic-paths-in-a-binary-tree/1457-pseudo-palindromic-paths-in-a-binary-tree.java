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
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        
        
        int[] frq = new int[10];
        getAllPossible(root, frq);
        return result;
    }
    private void getAllPossible(TreeNode root, int[] frq){
        if(root == null) return;
        
        frq[root.val] = frq[root.val] + 1;
        
        if(root.left == null && root.right == null){
            if(isPalindrome(frq)) {
                result++;
            }
        }
        
        getAllPossible(root.left, frq);
        getAllPossible(root.right, frq);
        
        frq[root.val] = frq[root.val] - 1;
    }
    private boolean isPalindrome(int[] frq){
        
        boolean flag = false;
        int cnt = 0;
        for(int ele : frq){
            
            if(ele % 2 != 0 ) cnt++;
            if(ele % 2 != 0 && cnt > 1) return false;
        }
        return true;
    }
}
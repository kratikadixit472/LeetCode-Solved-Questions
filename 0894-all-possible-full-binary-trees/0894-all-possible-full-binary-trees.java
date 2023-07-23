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
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        if(n <= 0) return new ArrayList<>();
        
        List<TreeNode>[] dp = new ArrayList[n+1];
        
        for(int i = 0 ; i <= n; i++){
           dp[i] = new ArrayList<>();
        }
        
        dp[1].add(new TreeNode(0));
        
        for(int i = 1; i <= n; i += 2){
            for(int node = 1; node < i; node += 2){
                for(TreeNode left : dp[node]){
                    for(TreeNode right : dp[i - 1 - node]){
                        TreeNode curr = new TreeNode(0);
                        curr.left = left;
                        curr.right = right;
                        dp[i].add(curr);
                    }
                }
            }
        }
        
        return dp[n];
    }
}
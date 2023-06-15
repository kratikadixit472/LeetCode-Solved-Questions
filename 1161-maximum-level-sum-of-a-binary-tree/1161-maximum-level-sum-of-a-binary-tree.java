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
    public int maxLevelSum(TreeNode root) {
        
        int ans = Integer.MIN_VALUE, level = 1, maxLevel = 1;
        
        LinkedList<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        
        while(!pq.isEmpty()){
            int sz = pq.size();
            int sum = 0;
            
            while(sz-- > 0){
                
                TreeNode node = pq.poll();
                
                sum += node.val;
                
                if(node.left != null) pq.add(node.left);
                if(node.right != null) pq.add(node.right);
            }
            
            if(ans < sum){
                ans = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}
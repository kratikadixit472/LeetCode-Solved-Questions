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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            int nodes = sz; 
            double sum = 0;
            while(sz-- > 0){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                sum += curr.val;
            }
            ans.add((double)(sum / nodes));
        }
        return ans;
    }
}
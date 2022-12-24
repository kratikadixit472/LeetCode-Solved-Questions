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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        
        if(root == null || u == null) return null;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz-- > 0){
                
                TreeNode top = q.poll();
                
                if(top.val == u.val){
                    if(q.size() > 0 && sz > 0) return q.poll();
                    else return null;
                }
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
        }
        return null;
    }
}
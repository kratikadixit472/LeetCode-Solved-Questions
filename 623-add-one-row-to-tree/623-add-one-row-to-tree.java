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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth == 1){
            TreeNode nhead = new TreeNode(val);
            nhead.left = root;
            return nhead;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                TreeNode node = q.poll();
                if(depth-1 == level){
                    TreeNode left = node.left, right = node.right;
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = left;
                    node.right.right = right;
                }
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            level++;
        }
        return root;
    }
}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> al = new ArrayList<>();
            while(sz-- > 0){
                
                TreeNode curr = q.poll();
                al.add(curr.val);
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(level % 2 == 0) Collections.reverse(al);
            ans.add(al);
            level++;
        }
        return ans;
    }
}
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
    
    List<Integer> ans = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        
        if(root == null) return ans;
        getNodes(root);
        return ans;
    }
    
    private void getNodes(TreeNode root){
        
        if(root == null) return;
        
        if(root.left != null) getNodes(root.left);
        if(root.right != null) getNodes(root.right);
          
        TreeNode node = null;
        
        if(root.left == null || root.right == null){
            // System.out.println("yes " + root.val+" ");
            node = (root.left != null) ? root.left : root.right;
        }
        if(node != null){
            ans.add(node.val);
            node = null;
        }
        
    }
}
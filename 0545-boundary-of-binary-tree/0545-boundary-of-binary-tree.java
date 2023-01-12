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

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ans.add(root.val);
        leftNodes(root.left);
        leavesNodes(root.left);
        leavesNodes(root.right);
        rightNodes(root.right);
        return ans;
    }
    private void leftNodes(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)) return;

        ans.add(root.val);

        if(root.left != null) leftNodes(root.left);
        else{
            leftNodes(root.right);
        }
    }
    private void leavesNodes(TreeNode root) {
        
        if(root == null) return;

        if(root.left == null && root.right == null){
            ans.add(root.val);
        }
        leavesNodes(root.left);
        leavesNodes(root.right);
    }
    private void rightNodes(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null)) return;
    
        if(root.right != null) rightNodes(root.right);
        else{
            rightNodes(root.left);
        }
        ans.add(root.val);
    }
}
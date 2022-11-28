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
    List<Integer> al = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        
        inorderTraverse(root);
        TreeNode head = sortedArrayToBST(0, al.size()-1);
        return head;
    }
    
    private void inorderTraverse(TreeNode root) {
        if(root == null) return;
        
        inorderTraverse(root.left);
        al.add(root.val);
        inorderTraverse(root.right);
    }
    
    private TreeNode sortedArrayToBST(int l, int r) {
        
        if(l > r) return null;
        int mid = (l + r) / 2;
        
        TreeNode root = new TreeNode(al.get(mid));
        root.left = sortedArrayToBST(l, mid-1);
        root.right = sortedArrayToBST(mid+1, r);
        
        return root;
    }
}
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
    
    
    public boolean findTarget(TreeNode root, int k) {
        
        if(root == null) return false;
        List<Integer> al = new ArrayList<>();
        inorder(root, al);
        
        int l = 0, r = al.size()-1;
        
        while(l < r){
            int sum = al.get(l) + al.get(r);
            if(sum == k){
                return true;
            }
            else if(sum < k) l++;
            else r--;
        }
        
        return false;
    }
    private void inorder(TreeNode root, List<Integer> al){
        if(root == null) return;
        
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
}
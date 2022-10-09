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
        Set<Integer> set = new HashSet<>();
        return check(root, k, set);

    }
    private boolean check(TreeNode root, int tar, Set<Integer> set){

        if(root == null) return false;

        if(set.contains(tar-root.val)) return true;

        set.add(root.val);

        return check(root.left, tar, set) || check(root.right, tar, set);
    }
}
 
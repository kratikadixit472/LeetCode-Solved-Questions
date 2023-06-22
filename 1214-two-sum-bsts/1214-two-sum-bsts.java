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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        
        DFS(root1, al1);
        DFS(root2, al2);
        
        for(int i = 0; i < al1.size(); i++){
            for(int j = 0; j < al2.size(); j++){
                if(al1.get(i) + al2.get(j) == target) return true;
            }
        }
        return false;
    }
    
    private void DFS(TreeNode root, List<Integer> al){
        if(root == null) return;
        
        al.add(root.val);
        DFS(root.left, al);
        DFS(root.right, al);
    }
}
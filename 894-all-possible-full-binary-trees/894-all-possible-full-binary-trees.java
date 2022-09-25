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
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        List<TreeNode> ans = new ArrayList<>();
        
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        if(n == 1){
            TreeNode node = new TreeNode(0);
            ans.add(node);
            return ans;
        }
        
        for(int i = 1; i < n; i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            
            for(TreeNode lft : left){
                for(TreeNode rgt : right){
                    TreeNode curr = new TreeNode(0);
                    curr.left = lft;
                    curr.right = rgt;
                    ans.add(curr);
                }
            }
        }
        map.put(n, ans);
        return ans;
    }
}
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
    public int[] findMode(TreeNode root) {
        
        if(root == null) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        inorderTraversal(root, map);
        
        int maxModeVal = Integer.MIN_VALUE;
        
        for(int val : map.values()){
            maxModeVal = Math.max(val, maxModeVal);
        }
        List<Integer> al = new ArrayList<>();
        
        for(int key : map.keySet()){
            if(map.get(key) == maxModeVal){
                al.add(key);
            }
        }
        int[] ans = new int[al.size()];
        
        for(int i = 0; i < al.size(); i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
    
    private void inorderTraversal(TreeNode root, Map<Integer, Integer> map){
        
        if(root == null) return;
        
        inorderTraversal(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorderTraversal(root.right, map);
    }
}
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        List<TreeNode> ans = new ArrayList<>();
        
        Map<String, List<TreeNode>> map = new HashMap<>();
        
        serialize(root, map);
        
        for(List<TreeNode> grp : map.values()){
            if(grp.size() > 1) {
                // for(TreeNode node : grp){
                //     System.out.print(node.val+ " ");
                // }
                ans.add(grp.get(0));
                // System.out.println();
            }
        }
        return ans;
    }
    
    private String serialize(TreeNode root, Map<String, List<TreeNode>> map){
        
        if(root == null) return "";
        
        String s = "(" + serialize(root.left, map) + root.val + serialize(root.right, map) + ")";
        
        // System.out.println(s);
        
        if(!map.containsKey(s)) map.put(s, new ArrayList<>());
        map.get(s).add(root);
        
        return s;
    }
}
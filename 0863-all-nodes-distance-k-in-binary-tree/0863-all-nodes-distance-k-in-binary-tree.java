/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private void getAllParentNodes(TreeNode root, Map<TreeNode, TreeNode> map) {
        
        if(root == null) return;
        
        if(root.left != null){
            map.put(root.left, root);
        }
        if(root.right != null){
            map.put(root.right, root);
        }
        getAllParentNodes(root.left, map);
        getAllParentNodes(root.right, map);
        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList<>();
        
        if(root == null || target == null) return ans;
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> vis = new HashSet<>();
        
        getAllParentNodes(root, map);
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.add(target);
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz-- > 0){
                TreeNode curr = q.poll();
               
                
                if(k == 0) ans.add(curr.val);

                if(curr.left != null && !vis.contains(curr.left)){
                    q.add(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right != null && !vis.contains(curr.right)){
                    q.add(curr.right);
                    vis.add(curr.right);
                }
                if(map.containsKey(curr) && !vis.contains(map.get(curr))){
                    q.add(map.get(curr));
                    vis.add(map.get(curr));
                }
            }
            k--;
        }
        return ans;
    }
}
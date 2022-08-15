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
    class Pair{
        TreeNode node;
        int vrt;
        public Pair(TreeNode node, int vrt){
            this.node = node;
            this.vrt = vrt;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            map.putIfAbsent(p.vrt, new ArrayList<>());
            map.get(p.vrt).add(p.node.val);
            min = Math.min(min, p.vrt);
            max = Math.max(max, p.vrt);
            
            if(p.node.left != null){
                q.add(new Pair(p.node.left, p.vrt-1));
            }
            if(p.node.right != null){
                q.add(new Pair(p.node.right, p.vrt+1));
            }
        }
        
        for(int i = min ; i<= max; i++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
}
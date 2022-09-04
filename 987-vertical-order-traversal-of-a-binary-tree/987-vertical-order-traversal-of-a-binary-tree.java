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
        int r, c;
        
        public Pair(TreeNode node, int r, int c){
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        // map.putIfAbsent(0, new ArrayList<>());
        // map.get(0).add(root.val);
        
        while(!q.isEmpty()){
            int sz = q.size();
            Pair top = q.poll();
            
            TreeNode node = top.node;
            int r = top.r, c = top.c;
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(new int[]{r, node.val});
            
            if(node.left != null){
                q.add(new Pair(node.left, r+1, c-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, r+1, c+1));
            }
        }
        
        for(List<int[]> al : map.values()){
            List<Integer> all = new ArrayList<>();
            Collections.sort(al, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
            for(int[] ele : al){
                all.add(ele[1]);
            }
            ans.add(all);
        }
        
        return ans;
    }
}
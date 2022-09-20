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
        
        int idx;
        TreeNode node;
        
        public Pair(int idx, TreeNode node){
            this.idx = idx;
            this.node = node;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        Deque<Pair> dq = new LinkedList<>();
        dq.add(new Pair(0, root));
        int maxWidth = 0;
        
        while(!dq.isEmpty()){
            
            int sz = dq.size();
            maxWidth = Math.max(maxWidth, dq.getLast().idx - dq.getFirst().idx + 1);
            
            while(sz-- > 0){
                Pair curr = dq.removeFirst();
                int idx = curr.idx;
                
                if(curr.node.left != null){
                    dq.add(new Pair(2*idx, curr.node.left));
                }
                if(curr.node.right != null){
                    dq.add(new Pair(2*idx + 1, curr.node.right));
                }
            }
        }
        return maxWidth;
    }
}
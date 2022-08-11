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
        int idx;
        
        public Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        Deque<Pair> dq = new LinkedList<>();
        
        dq.add(new Pair(root, 0));
        int maxWidth = 1;
        
        while(!dq.isEmpty()){
            while(!dq.isEmpty() && dq.getFirst() == null) dq.removeFirst();
            while(!dq.isEmpty() && dq.getLast() == null) dq.removeLast();
            
            maxWidth = Math.max(maxWidth, dq.getLast().idx - dq.getFirst().idx + 1);
            
            int sz = dq.size();
            while(sz-- > 0){
                Pair curr = dq.removeFirst();
                
                if(curr.node.left != null){
                    dq.add(new Pair(curr.node.left, 2*curr.idx + 1));  
                }
                if(curr.node.right != null){
                    dq.add(new Pair(curr.node.right, 2*curr.idx + 2)); 
                }
            }
        }
        return maxWidth;
    }
}
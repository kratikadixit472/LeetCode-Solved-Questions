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
    
    
    
    public void recoverTree(TreeNode root) {
        
        TreeNode first = null, sec = null, prev = null;
        Deque<TreeNode> st = new LinkedList<>();
        
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.add(root);
                root = root.left;
            }
            root = st.removeLast();
            
            if(prev != null && root.val < prev.val){
                if(first == null){
                    first = prev;
                }
                if(root.val < prev.val){
                    sec = root;
                }
            }
            prev = root;
            root = root.right;
        }
        
        int tmp = first.val;
        first.val = sec.val;
        sec.val = tmp;
    }
}
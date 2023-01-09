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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        LinkedList<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            if(root != null){
                st.push(root);
                ans.addFirst(root.val);
                root = root.right;
            }
            else{
                TreeNode node = st.pop();
                root = node.left;
            }
        }
        return ans;
    }
}
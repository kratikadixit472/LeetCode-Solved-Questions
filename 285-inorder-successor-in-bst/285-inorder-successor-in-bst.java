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
 
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null, curr = root;
        
        while(curr != null){
            
            if(p.val >= curr.val){
               //if(curr != null) System.out.println(curr.val);
                curr = curr.right;
            }
            else{
                successor = curr;
                //System.out.println(curr.val);
                curr = curr.left;
            }
        }
        return successor;
    }
}
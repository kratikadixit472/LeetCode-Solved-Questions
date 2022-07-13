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
    
    TreeNode successor = null;
    TreeNode prev = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if(p.right != null){
            
            TreeNode leftMost = p.right;
            
            while(leftMost.left != null){
                leftMost = leftMost.left;
            }
            
            successor = leftMost;
        }
        else case2(root, p);
        
        return successor;
    }
    
    private void case2(TreeNode root, TreeNode p){
        
        if(root == null) return;
        
        case2(root.left, p);
        
        if(prev == p && successor == null){
            successor = root;
            return;
        }
        
        prev = root;
        
        case2(root.right, p);
    }
}
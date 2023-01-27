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
    TreeNode tar = null;
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.right != null){
                root.val = getSucc(root.right);
                root.right = deleteNode(root.right, root.val);
            }
            else{
                root.val = getPre(root.left);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    private int getSucc(TreeNode root){
        
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    private int getPre(TreeNode root){
        
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}
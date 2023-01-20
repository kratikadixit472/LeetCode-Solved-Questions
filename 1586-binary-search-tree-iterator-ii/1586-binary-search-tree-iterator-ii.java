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
class BSTIterator {

    int idx, n;
    List<Integer> al;
    
    private void inorder(TreeNode root){
        if(root == null) return ;
        
        inorder(root.left);
        al.add(root.val);
        inorder(root.right);
    }
    
    public BSTIterator(TreeNode root) {
        
        al = new ArrayList<>();
        
        inorder(root);
        n = al.size();
        idx = -1;
    }
    
    public boolean hasNext() {
        return idx < n - 1;
    }
    
    public int next() {
        ++idx;
        return al.get(idx);
    }
    
    
    
    public boolean hasPrev() {
        return idx > 0;
    }
    
    public int prev() {
        --idx;
        return al.get(idx);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
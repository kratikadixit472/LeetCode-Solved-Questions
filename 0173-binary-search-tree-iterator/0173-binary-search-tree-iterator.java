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

    int idx;
    List<Integer> al;
    
    public BSTIterator(TreeNode root) {
        al = new ArrayList<>();
        inorderTraversal(root, al);
        idx = 0;
    }
    
    public int next() {
        return al.get(idx++);
    }
    
    public boolean hasNext() {
        return (idx < al.size());
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> al){
        
        if(root == null) return;
        
        inorderTraversal(root.left, al);
        al.add(root.val);
        inorderTraversal(root.right, al);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
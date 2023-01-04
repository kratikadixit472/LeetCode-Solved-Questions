/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private void  postOrder(TreeNode root, StringBuilder sb) {
        if(root == null) return ;
        
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(" ");
    }
    
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    private TreeNode getBST(int l, int r, Deque<Integer> dq){
        
        if(dq.isEmpty()) return null;
        
        int val = dq.getLast();
        if(val < l || val > r) return null;
        
        dq.removeLast();
        
        TreeNode root = new TreeNode(val);
        root.right = getBST(val, r, dq);
        root.left = getBST(l, val, dq);
        
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length() <= 0 || data == null) return null;
        Deque<Integer> dq = new LinkedList<Integer>();
        
        for(String s : data.split("\\s+")){
            dq.add(Integer.valueOf(s));
        }
        
        TreeNode root = getBST(Integer.MIN_VALUE, Integer.MAX_VALUE, dq);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
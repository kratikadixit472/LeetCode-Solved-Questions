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
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb =new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val +" ");
            q.add(node.left);
            q.add(node.right);
        }
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == "") return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        String[] st = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(st[0]));
        q.add(root);
        
        for(int i=1; i<st.length; i++){
            TreeNode parent = q.poll();
            
            if(!st[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(st[i]));
                parent.left = left;
                q.add(left);
            }
            if(!st[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(st[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
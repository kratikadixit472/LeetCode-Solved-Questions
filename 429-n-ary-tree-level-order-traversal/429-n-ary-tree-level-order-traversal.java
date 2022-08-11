/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> al = new ArrayList<>();
            while(sz-- > 0){
                
                Node node = q.poll();
                al.add(node.val);
                
                for(Node child : node.children){
                    if(child != null){
                        q.add(child);
                    }
                }
            }
            ans.add(al);
        }
        return ans;    
    }
}
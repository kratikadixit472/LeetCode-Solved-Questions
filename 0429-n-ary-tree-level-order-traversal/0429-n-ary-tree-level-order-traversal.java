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
            List<Integer> al = new ArrayList<>();
            int sz = q.size();
            while(sz-- > 0){
                
                Node curr = q.poll();
                al.add(curr.val);
                
                for(Node ngbr : curr.children){
                    if(ngbr != null){
                        q.add(ngbr);
                    }
                }
            }
            ans.add(al);
        }
        return ans;
    }
}
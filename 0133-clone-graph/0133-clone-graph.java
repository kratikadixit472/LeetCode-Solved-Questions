/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        
        LinkedList<Node> q = new LinkedList<>();
        Map<Node, Node> vis = new HashMap<>();
        
        q.add(node);
        vis.put(node, new Node(node.val, new ArrayList<>()));
        
        while(!q.isEmpty()){
            int sz = q.size();
            Node top = q.poll();
            
            for(Node ngbr : top.neighbors){
                if(!vis.containsKey(ngbr)){
                    vis.put(ngbr, (new Node(ngbr.val, new ArrayList<>())));
                    q.add(ngbr);
                }
                vis.get(top).neighbors.add(vis.get(ngbr));
            }
        }
        return vis.get(node);
    }
}

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
    
    Map<Node, Node> vis = new HashMap<>();
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        
        if(vis.containsKey(node)) return vis.get(node);
        
        Node cloneNode = new Node(node.val, new ArrayList<>());
        vis.put(node, cloneNode);
        
        for(Node ngbr : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(ngbr));
        }
        return cloneNode;
    }
}
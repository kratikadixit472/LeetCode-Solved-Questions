/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        int pdepth = findDepth(p), qdepth = findDepth(q);
        
        while(pdepth > qdepth){
            pdepth--;
            p = p.parent;
        }
        
        while(pdepth < qdepth){
            qdepth--;
            q = q.parent;
        }
        
        while(p != q){
            p = p.parent ;
            q = q.parent ;
        }
        
        return p;
    }
    
    private int findDepth(Node node){
        int depth = 0;
        while(node != null){
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
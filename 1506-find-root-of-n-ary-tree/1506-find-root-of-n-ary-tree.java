/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        
        int valueSum = 0;
        
        for(Node node : tree){
            
            valueSum += node.val;
            for(Node child : node.children){
                valueSum -= child.val;
            }
        }
        
        Node root = null;
        
        for(Node node : tree){
            if(node.val == valueSum){
                root = node;
                break;
            }
        }
        return root;
    }
}
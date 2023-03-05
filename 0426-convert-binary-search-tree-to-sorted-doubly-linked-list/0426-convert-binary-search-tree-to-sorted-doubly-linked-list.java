/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        
        Node nhead = new Node(-1);
        Node curr = root, prev = nhead;
        
        Stack<Node> st = new Stack<>();
        
        while(!st.isEmpty() || curr != null){
            
            while(curr != null){
                st.add(curr);
                curr = curr.left;
            }
            
            curr = st.pop();
            prev.right = curr;
            curr.left = prev;
            prev = curr;
            curr = curr.right;
        }
        
        nhead.right.left = prev;
        prev.right = nhead.right;
        
        return nhead.right;
    }
}
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

    Node head = null, prev = null;

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;

        inOrder(root);
        
        prev.right = head;
        head.left = prev;

        return head;
    }
    
    private void inOrder(Node root) {
        if(root == null) return ;
        
        inOrder(root.left);
        
        if(head == null){
            head = root;
        }
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inOrder(root.right);

        return;
    }
}
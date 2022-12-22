/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node nhead = new Node(0, null, head, null);
        Node curr, prev = nhead;
        
        Stack<Node> st = new Stack<>();
        st.add(head);
        
        while(!st.isEmpty()){
            
            curr = st.pop();
            prev.next = curr;
            curr.prev = prev;
            
            if(curr.next != null) st.add(curr.next);
            if(curr.child != null){
                st.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        nhead.next.prev = null;
        
        return nhead.next;
    }
}
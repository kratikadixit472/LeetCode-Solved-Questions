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
    Node tail = null;
    
    public Node flatten(Node head) {
        if(head == null) return null;
        
        head.prev = tail;
        tail = head;
        
        Node next = head.next;
        head.next = flatten(head.child);
        head.child = null;
        
        tail.next = flatten(next);
        return head;
    }
}
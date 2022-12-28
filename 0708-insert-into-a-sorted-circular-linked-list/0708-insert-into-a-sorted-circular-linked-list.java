/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newN = new Node(insertVal);
        
        if(head == null){
            head = newN;
            newN.next = head;
            return head;
        }
        
        Node curr = head;
        
        while(curr.next != head){
            if(curr.val <= curr.next.val){
                if(curr.val <= insertVal && curr.next.val >= insertVal) break;
            }
            else{
                if(curr.val <= insertVal || curr.next.val >= insertVal) break;
            }
            curr = curr.next;
        }
        Node nextNode = curr.next;
        
        curr.next = newN;
        newN.next = nextNode;
        
        return head;
    }
}
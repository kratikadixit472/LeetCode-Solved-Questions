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
    public Node inorderSuccessor(Node node) {
        
        if(node.right != null){
            Node leftMost = node.right;
            
            while(leftMost.left != null){
                leftMost = leftMost.left;
            }
            return leftMost;
        }
        
        
        else{
            Node result = node.parent;
            while(result != null && result.val < node.val){
                result = result.parent;
            }
            return result;
        }
    }
}
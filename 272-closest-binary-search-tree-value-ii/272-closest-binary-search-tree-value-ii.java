/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Pair{
//     double diff;
//     int node;

//     public Pair(double target, int node){
//         this.diff = Math.abs(target - node);
//         this.node = node;
//     }
// }

class Pair {
    public int value;
    public Double distance;
    
    public Pair(int value, double target) {
        this.value = value;
        this.distance = Math.abs(value-target);
    }
}
    

class Solution {
    
    List<Integer> ans ;
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        ans = new ArrayList<>();
        
        // PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> p1.diff.compareTo(p2.diff));
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance.compareTo(y.distance));
        
        getClosest(root, target, k, pq);
        
        while(k-- > 0 && !pq.isEmpty()){
            ans.add(pq.poll().value);
            
        }
        return ans;
    }
    
    private void getClosest(TreeNode root, double target, int k, PriorityQueue<Pair> pq){
        
        if(root == null) return;
        
        getClosest(root.left, target, k, pq);
        pq.add(new Pair (root.val, target));
        getClosest(root.right, target, k, pq);
        
    }
}
class Solution {
    Map<Integer, Set<Integer>> adj;
    int[] ans, count;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        ans = new int[n];
        count = new int[n];
        adj = new HashMap<>();
        
        for(int i = 0 ; i < n; i++){
            adj.put(i, new HashSet<>());
        }
        Arrays.fill(count, 1);
        
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        postOrder(0, -1);
        preOrder(0, -1, n);
        
        return ans;
    }
    private void postOrder(int node, int root){
        for(int child : adj.get(node)){
            if(child != root){
                postOrder(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }
    private void preOrder(int node, int root, int n){
        for(int child : adj.get(node)){
            if(child != root){
                ans[child] = ans[node] - count[child] + n - count[child];
                preOrder(child, node, n);
            }
        }
    }
}
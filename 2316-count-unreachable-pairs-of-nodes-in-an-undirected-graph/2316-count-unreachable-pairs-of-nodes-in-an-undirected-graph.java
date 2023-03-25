class Solution {
    
    long count = 0;
    
    public long countPairs(int n, int[][] edges) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        boolean[] vis = new boolean[n];
        long ans = 0;
        
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                DFS(i, vis, graph);
                
                ans += (count * (n - count));
                count = 0;
            }
        }
        return ans / 2;
    }
    
    private void DFS(int curr, boolean[] vis, List<Integer>[] graph) {
        
        vis[curr] = true;
        count++;
        
        for(int n : graph[curr]){
            if(!vis[n]){
                DFS(n, vis, graph);
            }
        }
    }
}
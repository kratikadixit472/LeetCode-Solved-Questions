class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] e : edges){
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        return DFS(0, -1, adj, hasApple, new boolean[n]);
    }
    
    private int DFS(int node, int par, Map<Integer, List<Integer>> adj, List<Boolean> hasApple, boolean[] vis) {
        
        if(vis[node]) return 0;
        
        vis[node] = true;
        
        int totalTime = 0, childTime = 0;
        
        for(int child : adj.get(node)){
            if(child == par){
                continue;
            }
            
            childTime = DFS(child, node, adj, hasApple, vis);
            
            if(childTime > 0 || hasApple.get(child)){
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}
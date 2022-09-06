class Solution {
    int mod = (int)(1e9 + 7);
    
    public int countRestrictedPaths(int n, int[][] edges) {
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for(int i = 0 ; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        
        int[] dist = dikshtra(n, graph);
        
        return DFS(1, n, graph, dist, new Integer[n+1]);
    }
    
    private int DFS(int src, int dest, List<int[]>[] graph, int[] dis, Integer[] dp){
        if(dp[src] != null) return dp[src];
        
        if(src == dest) {
            return 1;
        }
        
        int count = 0;
        for(int[] e : graph[src]){
            if(dis[src] > dis[e[0]]){
               count = (count + DFS(e[0], dest, graph, dis, dp)) % mod;
            }
        }
        return dp[src] = count;
    }
    
    private int[] dikshtra(int d, List<int[]>[] graph){
        
        int[] dist = new int[d+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[]{d, 0});
        dist[d] = 0;
        
        while(!pq.isEmpty()){
            
            int[] top = pq.poll();
            int u = top[0], dis = top[1];
            
            if(dis != dist[u]) continue;
            
            for(int[] ngbr : graph[u]){
                
                int v = ngbr[0], w = ngbr[1];
                
                if(dist[v] > dis + w){
                    dist[v] = dis + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
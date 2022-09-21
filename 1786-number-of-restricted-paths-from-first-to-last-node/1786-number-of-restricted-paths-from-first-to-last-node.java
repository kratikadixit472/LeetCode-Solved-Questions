class Solution {
    
    int mod = (int)(1e9 + 7);
    public int countRestrictedPaths(int n, int[][] edges) {
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        
        int[] minW = new int[n+1];
        Arrays.fill(minW, Integer.MAX_VALUE);
        
        dikshtra(n, graph, minW);
        
        return DFS(1, n, graph, minW, new Integer[n+1]);
        
    }
    private int DFS(int src, int dest, List<int[]>[] graph, int[] w, Integer[] dp){
        
        if(dp[src] != null) return dp[src];
        
        if(src == dest){
            return 1;
        }
        
        int count = 0;
        for(int[] next : graph[src]){
            if(w[next[0]] < w[src]){
                count = (count + DFS(next[0], dest, graph, w, dp)) % mod;
            }
        }
        return dp[src] = count;
    }
                            
    private void dikshtra(int n, List<int[]>[] graph, int[] minW){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[]{n, 0});
        minW[n] = 0;
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            
            int curr = top[0], w = top[1];
            
            for(int[] ngbr : graph[curr]){
                int next = ngbr[0], cost = ngbr[1];
                if(minW[next] > w + cost){
                    minW[next] = w + cost;
                    pq.add(new int[]{next, w + cost});
                }
            }
        }
    }                       
}
class Solution {
  
    private boolean touch(int i, int j, int[][] boms){
        
        long x = Math.abs(boms[i][0] - boms[j][0]);
        long y = Math.abs(boms[i][1] - boms[j][1]);
        long r = boms[i][2];
        
        return (x*x + y*y <= r*r);
    }
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    if(touch(i, j, bombs)){
                        graph[i].add(j);
                    }
                }
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            boolean[] vis = new boolean[n];
            int cnt = DFS(i, graph, vis);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
    private int DFS(int src, List<Integer>[] graph, boolean[] vis){
        
        vis[src] = true;
        
        int cnt = 1;
        for(int e : graph[src]){
            if(!vis[e]) {
                cnt += DFS(e, graph, vis);
            }
        }
        
        return cnt;
    }
}
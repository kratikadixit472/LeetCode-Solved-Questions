class Solution {
    
    private boolean isTouching(int i, int j, int[][] bombs){
        
        long x = Math.abs(bombs[i][0] - bombs[j][0]);
        long y = Math.abs(bombs[i][1] - bombs[j][1]);
        long r = bombs[i][2];
        
        return (x * x + y * y) <= (r * r);
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
                    if(isTouching(i, j, bombs)){
                        graph[i].add(j);
                    }
                }
            }
        }
        
        boolean[] vis;
        
        int maxBombs = 0;
        
        for(int i = 0; i < n; i++){
            vis = new boolean[n];
            maxBombs = Math.max(maxBombs, DFS(i, vis, graph));
        }
        return maxBombs;
    }
    
    private int DFS(int src, boolean[] vis, List<Integer>[] graph){
        vis[src] = true;
        
        int count = 1;
        
        for(int next : graph[src]){
            if(!vis[next]){
                count += DFS(next, vis, graph);
            }
        }
        return count;
    }
}
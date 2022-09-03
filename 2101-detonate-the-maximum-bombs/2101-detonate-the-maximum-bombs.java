class Solution {
    
    int count;
    
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int N = 0;
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(i != j){
                    if(isTouching(bombs[i], bombs[j])){
                        graph[i].add(j);
                    }
                }
            }
        }
        
        boolean[] vis;
        
        for(int i = 0 ; i < n; i++){ 
            
            vis = new boolean[n];
            DFS(i, graph, vis);
            ans = Math.max(ans, count);
            count = 0;
        }
        return ans;
    }
    
    private boolean isTouching(int[] b1, int[] b2){
        
        long x = Math.abs(b1[0]  - b2[0]);
        long y  = Math.abs(b1[1]  - b2[1]);
        long r = b1[2];
        
        if(x*x + y*y <= r*r) return true;
        
        return false;
    }
    
    private void DFS(int src, List<Integer>[] graph, boolean[] vis){
        
        
        vis[src] = true;
        
        count++;
        
        for(int e : graph[src]){
            if(!vis[e]){
                DFS(e, graph, vis);
            }
        }
    }
}
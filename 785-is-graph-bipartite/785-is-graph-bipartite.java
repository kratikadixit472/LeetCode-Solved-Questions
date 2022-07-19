class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < n; i++){
            if(vis[i] == -1 && !BFS(i, graph, vis)) return false;
        }
        return true;
    }
    
    private boolean BFS(int src, int[][] graph, int[] vis) {
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);
        
        int color = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int rvtx = q.poll();
                
                if(vis[rvtx] != -1){
                    if(vis[rvtx] != color) return false;
                    else continue;
                }
                
                vis[rvtx] = color;
                
                for(int e : graph[rvtx]){
                    if(vis[e] == -1) q.add(e);
                }
            }
            color = (color + 1) % 2;
        }
        return true;
    }
}
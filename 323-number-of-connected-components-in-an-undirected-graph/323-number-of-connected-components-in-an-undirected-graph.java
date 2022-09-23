class Solution {
    
    int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    
    public int countComponents(int n, int[][] edges) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        boolean[] vis = new boolean[n];
        int cnt = 0;
        
        for(int i = 0 ; i < n; i++){
            if(!vis[i]){
                cnt++;
                DFS(i, graph, vis);
            }
        }
        return cnt;
    }
    private void DFS(int src, List<Integer>[] graph, boolean[] vis){
        vis[src] = true;
        
        for(int e : graph[src]){
            if(!vis[e]) DFS(e, graph, vis);
            
        }
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        int cnt = 0;
        
        for(int i = 0 ; i < n; i++){
            if(vis[i] == -1){
                if(cnt == 1) return false;
                cnt++;
                if(DFS(i, graph, vis)) return false;
            }
        }
        return true;
    }
    private boolean DFS(int src, List<Integer>[] graph, int[] vis){
        
        // if(vis[src] == 1) return true;
        vis[src] = 1;
        
        for(int e : graph[src]){
            if(vis[e] == -1){
                if(DFS(e, graph, vis)) return true;
            }
            else if(vis[e] == 2)return true;
        }
        vis[src] = 2;
        return false;
    }
}
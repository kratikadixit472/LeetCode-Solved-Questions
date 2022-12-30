class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        
        if(DFS(0, vis, adj)) return false;
        
        for(int i =0 ; i < n; i++){
            if(vis[i] == -1) return false;
        }
        
        return true;
    }
    private boolean DFS(int i, int[] vis, List<Integer>[] adj){
        
        vis[i] = 1;  
        
        for(int ngbr : adj[i]){
            if(vis[ngbr] == -1){
                if(DFS(ngbr, vis, adj)) return true;
            }
            else if(vis[ngbr] == 0) return true;
        }
        vis[i] = 0;
        
        return false;
    }
}
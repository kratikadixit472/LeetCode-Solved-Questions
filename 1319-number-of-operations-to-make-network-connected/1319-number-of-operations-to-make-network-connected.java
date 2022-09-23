class Solution {
    
    // 1. union find
    
    int[] par, size;
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1) return -1;
        
        par = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        int componenet = n;
        
        for(int[] e : connections){
            int p1 = findPar(e[0]), p2 = findPar(e[1]);
            if(p1 != p2){
                par[p2] = p1;
                componenet--;
            }
        }
        return componenet-1;
    }
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    
    // 2. DFS Connected components
    
    /*public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1) return -1;
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] conn : connections){
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(conn[0]);
        }
        
        int ans = 0;
        boolean[] vis = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!vis[i]){
        
                DFS(i, graph, vis );
                ans++;
            }
        }
        
        return ans-1;
    }
    
    private void DFS(int src, List<Integer>[] graph, boolean[] vis ){
        
        vis[src] = true;
        
        for(int e : graph[src]){
            if(!vis[e]) DFS(e, graph, vis );
        }
    }*/
}
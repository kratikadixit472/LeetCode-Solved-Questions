class Solution {
   
    int[] par ;
    
    private int findPar(int u){
        return ((par[u] == u) ? u : (par[u] = findPar(par[u])));
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int e[] : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        return DFS(source, destination, graph, new boolean[n]);
         // ans;
    }
    
    private boolean DFS(int src, int dest, List<Integer>[] graph, boolean[] vis){
        
        if(src == dest) {
            return true;
        }
        boolean ans = false;
        
        vis[src] = true;
        
        for(int e : graph[src]){
            if(!vis[e]) {
                ans = ans || DFS(e, dest, graph, vis);
            }
        }
        return ans;
    }
        /*par = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        for(int[] e : edges){
            
            int p1 = findPar(e[0]), p2 = findPar(e[1]);
            
            if(p1 != p2){
                par[p2] = par[p1];
            }
        }
        
        return findPar(source) == findPar(destination);
    }
    */
    
}
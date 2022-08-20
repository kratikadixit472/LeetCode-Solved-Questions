class Solution {
    boolean ans = false;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int e[] : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
         DFS(source, destination, graph, new boolean[n]);
        return ans;
    }
    
    private void DFS(int src, int dest, List<Integer>[] graph, boolean[] vis){
        
        if(src == dest) {
            ans = true;
            return ;
        }
        
        vis[src] = true;
        
        for(int e : graph[src]){
            if(!vis[e]) DFS(e, dest, graph, vis);
        }
    }
}
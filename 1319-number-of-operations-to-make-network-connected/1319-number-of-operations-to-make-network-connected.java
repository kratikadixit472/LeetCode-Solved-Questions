class Solution {
    int count = 0;
    public int makeConnected(int n, int[][] connections) {
        
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
                // System.out.print(i+" ");
            }
        }
        
        // ans--;
        return ans-1;
    }
    
    private void DFS(int src, List<Integer>[] graph, boolean[] vis ){
        
        vis[src] = true;
        
        for(int e : graph[src]){
            if(!vis[e]) DFS(e, graph, vis );
            //else count++;
        }
    }
}
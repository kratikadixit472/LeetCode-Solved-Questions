class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] pair : edges){
            graph[pair[0]].add(pair[1]);
        }
        
        if(graph[destination].size() != 0) return false;
        
        return DFS(source, destination, graph, vis);
    }
    
    private boolean DFS(int src, int des, List<Integer>[] edges, int[] vis){
        
        if(src == des) return true;
        
        if(edges[src].size() == 0) return false;
        
        boolean res = true;
        
        vis[src] = 0;
        for(int e : edges[src]){
            if(vis[e] == -1){
                res = res && DFS(e, des, edges, vis);
               // System.out.println(res+ " Yes");
            }
            else if(vis[e] == 0) return false;
        }
        
        vis[src] = 1;
        return res;
    }
}
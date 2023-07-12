class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> ans = new ArrayList<>();
        
        int n = graph.length;
        if(graph == null || n <= 0) return ans;
        
        int[] vis = new int[n];
        
        for(int i = 0; i < n; i++){
            if(DFS(i, graph, vis)) ans.add(i);
        }
        return ans;
    }
    
    private boolean DFS(int start, int[][] graph, int[] vis){
        
        if(vis[start] != 0) return vis[start] == 1;
        
        vis[start] = 2;
        for(int e : graph[start]){
            if(!DFS(e, graph, vis)) return false;
        }
        
        vis[start] = 1;
        return true;
    }
}
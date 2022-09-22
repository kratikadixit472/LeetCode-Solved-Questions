class Solution {
    
    private boolean sameRowCol(int i, int j, int[][] grid){
        if(grid[i][0] == grid[j][0] || grid[i][1] == grid[j][1]) return true;
        return false;
    }
    
    public int removeStones(int[][] stones) {
        
        int n = stones.length, cnt = 0;
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0 ; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(sameRowCol(i, j, stones)){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        int component = 0;
        
        for(int i = 0; i < n; i++){
            if(!vis[i]) {
                DFS(i, graph, vis);
                component++;
            }
        }
        
        return n - component;
    }
    private void DFS(int i, List<Integer>[] graph, boolean[] vis){
        
        vis[i] = true;
        for(int e : graph[i]){
            if(!vis[e]) {
                DFS(e, graph, vis);
            }
        }
    }
}
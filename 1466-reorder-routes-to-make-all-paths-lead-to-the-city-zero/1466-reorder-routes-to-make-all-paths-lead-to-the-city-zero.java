class Solution {
    public int minReorder(int n, int[][] connections) {
        
        List<List<Integer>> al = new ArrayList<>(n);
        
        for(int i = 0; i < n; ++i) 
        al.add(new ArrayList<>());
        
        for(int[] conn : connections){
            al.get(conn[0]).add(conn[1]);
            al.get(conn[1]).add(-conn[0]);
        }
        
        return DFS(0, al, new boolean[n]);
    }
    
    private int DFS(int from, List<List<Integer>> graph, boolean[] vis){
        
        int change = 0;
        vis[from] = true;
        
        for(int e : graph.get(from)){
            if(!vis[Math.abs(e)]){
                change += DFS(Math.abs(e), graph, vis) + (e > 0 ? 1 : 0);
            }
        }
        return change;
    }
}
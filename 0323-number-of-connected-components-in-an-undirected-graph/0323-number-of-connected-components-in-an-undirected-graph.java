class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int connected = 0;
        boolean[] vis = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                DFS(i, vis, graph);
                connected++;
            }
        }
        return connected;
    }
    private void DFS(int curr, boolean[] vis, List<Integer>[] graph){

        vis[curr] = true;

        for(int ngbr : graph[curr]){
            if(!vis[ngbr]){
                DFS(ngbr, vis, graph);
            }
        }
    }
}
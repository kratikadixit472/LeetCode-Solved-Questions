class Solution {
    
    int diameter = 0;
    
    public int treeDiameter(int[][] edges) {
        
        int n = edges.length;
        
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i = 0 ; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        boolean[] vis = new boolean[n+1];
        
        DFS(0, vis, graph);
        return diameter;
    }
    
    private int DFS(int curr, boolean[] vis, List<Integer>[] graph){
        
        vis[curr] = true;
        
        int firstMax = 0, secMax = 0;
        
        for(int ngbr : graph[curr]){
            int dis = 0;
            if(vis[ngbr]) continue;
            dis = 1 + DFS(ngbr, vis, graph);
            
            if(firstMax < dis){
                secMax = firstMax;
                firstMax = dis;
            }
            else if(secMax < dis){
                secMax = dis;
            }
        }
        
        diameter = Math.max(diameter, firstMax + secMax);
        
        return firstMax;
    }
}
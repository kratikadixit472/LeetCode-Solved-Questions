class Solution {
    
    int[] par;
    
    private int findPar(int u){
        
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    
    private int calDistance(int[][] points, int i, int j){
        
        return (Math.abs(points[i][0] - points[j][0]) + (Math.abs(points[i][1] - points[j][1])));
        
    }
    
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        
        List<int[]> connectAllPoints = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                connectAllPoints.add(new int[] {calDistance(points, i, j), i, j});
            }
        }
        
        Collections.sort(connectAllPoints, (a, b) -> a[0] - b[0]);
        
        par = new int[n];
        
        for(int i = 0; i < n; i++) par[i] = i;
        
        int cost = 0;
        
        for(int[] e : connectAllPoints){
            int u = e[1], v = e[2], w = e[0];
            
            int p1 = findPar(u), p2 = findPar(v);
            
            if(p1 != p2){
                par[p1] = par[p2];
                
                cost += w;
            }
        }
        
        return cost;
    }
}
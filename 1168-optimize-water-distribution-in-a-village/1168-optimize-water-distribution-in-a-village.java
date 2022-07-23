class Solution {
    
    int[] par;
    
    private int findPar(int u){
        
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        int[][] houses = new int[pipes.length + wells.length][3];
        
        int cost = 0;
        
        int idx = 0;
        for(int[] pipe : pipes){
            houses[idx][0] = pipe[0]; 
            houses[idx][1] = pipe[1]; 
            houses[idx++][2] = pipe[2]; 
        }
        
        for(int i = 0; i < n; i++){
            houses[idx][0] = 0;
            houses[idx][1] = i+1;
            houses[idx++][2] = wells[i];
        }
        
        Arrays.sort(houses, (a, b) -> {
            
            return a[2] - b[2];
            
        });
        
        par = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            par[i] = i;
        }
        
        for(int[] edge : houses){
            int u = edge[0], v = edge[1], w = edge[2];
            
            //System.out.println(u +" "+ v +" "+ w);
            int p1 = findPar(u), p2 = findPar(v);
            
            if(p1 != p2){
                par[p1] = par[p2];
                cost += w;
            }
        }
        
        return cost;
    }
}
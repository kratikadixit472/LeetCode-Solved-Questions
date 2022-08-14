class Solution {
    
    int[] par;
    
    private int findPar(int u){
        
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int minimumCost(int n, int[][] connections) {
        
        int ans = 0;
        
        Arrays.sort(connections, (a, b) -> {
            return a[2] - b[2];
        });
        
        par = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            par[i] = i;
        }
        
        for(int edges[] : connections){
            int x = edges[0], y = edges[1], w = edges[2];
            int p1 =findPar(x), p2 = findPar(y);
            if(p1 != p2){
                par[p2] = p1;
                ans += w;
                n--;
            }
        }
        
        return (n > 1) ? -1 : ans;
    }
}
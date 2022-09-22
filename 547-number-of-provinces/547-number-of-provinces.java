class Solution {
    
    int[] par;
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length, m = isConnected[0].length;
        
        par = new int[n+1];
        for(int i = 0; i <= n ; i++){
            par[i] = i;
        }
        int connected = n;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < m; j++){
                if(isConnected[i][j] == 0) continue;
                
                int p1 = findPar(i+1), p2 = findPar(j+1);
                
                if(p1 != p2){
                    par[p1] = par[p2];
                    connected--;
                }
            }
        }
        return connected;
    }
}
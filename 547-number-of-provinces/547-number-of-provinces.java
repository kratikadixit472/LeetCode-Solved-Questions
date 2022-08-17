class Solution {
    int[] par;
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int provinces = n;
        
        par = new int[n];
        
        for(int i = 0; i < n; i++) par[i] = i;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                if(i != j && isConnected[i][j] == 1){
                    int p1 = findPar(i), p2 = findPar(j);
                    if(p1 != p2){
                        par[p1] = p2;
                        provinces--;
                    }
                }
            }
        }
        return provinces;
    }
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
}
class Solution {
    
    int[] par;
    
    public int makeConnected(int n, int[][] connections) {
        
        if(n-1 > connections.length) return -1;
        
        par = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        int components = n;
        
        for(int[] c : connections){
            int p1 = findPar(c[0]), p2 = findPar(c[1]);
            
            if(p1 != p2){
                par[p1] = p2;
                components--;
            }
        }
        return components - 1;
    }
    
    private int findPar(int u){
        
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
        
    }
}
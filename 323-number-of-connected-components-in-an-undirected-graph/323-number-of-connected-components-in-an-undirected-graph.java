class Solution {
    
    int[] par, w;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int countComponents(int n, int[][] edges) {
        
        par = new int[n];
        w = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
            w[i] = 1;
        }
        
        int connected = n;
        for(int e[] : edges){
            connected = connected - union(e[0], e[1]);
        }
        
        return connected;
    }
    
    private int union(int x, int y){
        int p1 = findPar(x), p2 = findPar(y);
        
        if(p1 != p2){
            if(w[p1] > w[p2]){
                w[p1] += w[p2];
                par[p2] = p1;
            }
            else{
                w[p2] += w[p1];
                par[p1] = p2;
            }
            return 1;
        }
        else{
            return 0;
        }
    }
}
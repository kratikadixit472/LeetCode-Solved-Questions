class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        par = new int[n+1];
        
        for(int i = 0; i <= n ; i++){
            par[i] = i;
        }
        
        for(int[] e : edges){
            int p1 = findPar(e[0]), p2 = findPar(e[1]);
            
            if(p1 != p2){
                par[p2] = p1;
            }
            else return e;
        }
        return new int[2];
    }
}
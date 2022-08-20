class Solution {
   
    int[] par ;
    
    private int findPar(int u){
        return ((par[u] == u) ? u : (par[u] = findPar(par[u])));
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        par = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        for(int[] e : edges){
            
            int p1 = findPar(e[0]), p2 = findPar(e[1]);
            
            if(p1 != p2){
                par[p2] = par[p1];
            }
        }
        
        return findPar(source) == findPar(destination);
    }
    
    
}
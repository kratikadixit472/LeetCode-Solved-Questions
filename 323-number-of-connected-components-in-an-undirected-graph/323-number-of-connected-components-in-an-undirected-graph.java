class Solution {
    
    int[] par, size;
    public int countComponents(int n, int[][] edges) {
        
        par = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
            //size[i] = 1;
        }
        
        int componenet = n;
        
        for(int[] e : edges){
            int p1 = findPar(e[0]), p2 = findPar(e[1]);
            if(p1 != p2){
                par[p2] = p1;
                componenet--;
            }
        }
        return componenet;
    }
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
}
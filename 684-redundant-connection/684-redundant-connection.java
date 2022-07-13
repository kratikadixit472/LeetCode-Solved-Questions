class Solution {
    
    static int[] par, size;
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        par = new int[n+1];
        
        for(int i =0 ;i <= n ; i++){
            par[i] = i;
        }
        
        for(int[] edge : edges){
            
            int p1 = findPar(edge[0]), p2 = findPar(edge[1]);
            
            //System.out.print(edge[0] +" parent -> "+ p1 + ", "+edge[1] +" parent -> "+ p2 +", ");
            
            if(p1 != p2){
                //par[p1] = par[p2];
                union(p1, p2);
            }
            else return edge;
        }
        System.out.println();
        return edges[0];
    }
    
    private int findPar(int u){
        
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    private void union(int x, int y) {
        par[x] = par[y];
    }
}
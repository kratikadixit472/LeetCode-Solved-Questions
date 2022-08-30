class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        par = new int[n+1];
        
        int[] child1 = {-1, -1};
        int[] child2 = {-1, -1};
        
        for(int[] e : edges){
            int father = e[0], child = e[1];
            
            if(par[child] == 0){
                par[child] = father;
            }
            else{
                child2 = new int[] {e[0], e[1]};
                child1 = new int[] {par[child], e[1]};
                e[1] = 0;
            }
        }
        
        for(int  i =1; i <= n ; i++){
            par[i] = i;
        }
        
        for(int[] e : edges){
            
            int father = e[0], child = e[1];
            if(child == 0) continue;
            
            if(findPar(father) == child){
                if(child1[0] == -1) return e;
                else return child1;
            }
            par[child] = father;
        }
        
        return child2;
    }
}
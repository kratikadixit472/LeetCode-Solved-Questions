class Solution {
    
    int[] aPar, bPar;
    
    private int findPar(int u, int[] par){
        return (par[u] == u) ? u : (par[u] = findPar(par[u], par));
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        aPar = new int[n+1];
        bPar = new int[n+1];
        
        int alice = 0, bob = 0, removeEdge = 0;
        
        for(int i = 0 ; i <= n; i++){
            aPar[i] = bPar[i] = i;
        }
        
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        
        for(int[] e : edges){
            
            if(e[0] == 3){
                boolean aflag = union(e[1], e[2], aPar);
                boolean bflag = union(e[1], e[2], bPar);
                
                if(!aflag && !bflag) removeEdge++;
                if(aflag) alice++;
                if(bflag) bob++;
            }
            else if(e[0] == 2){
                boolean bflag = union(e[1], e[2], bPar);
                
                if(!bflag) removeEdge++;
                else{
                    bob++;
                }
            }
            else{
                boolean aflag = union(e[1], e[2], aPar);
                
                if(!aflag) removeEdge++;
                else{
                    alice++;
                }
            }
        }
        if(alice == n-1 && bob == n-1) return removeEdge;
        return -1;
    }
    
    private boolean union(int x, int y, int[] par){
        
        int p1 = findPar(x, par);
        int p2 = findPar(y, par);
        
        if(p1 != p2){
            par[p2] = p1;
            return true;
        }
        return false;
    }
}
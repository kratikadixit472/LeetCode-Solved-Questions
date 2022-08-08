class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        par = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        boolean[] ans = new boolean[requests.length];
        int idx = 0;
        
        for(int i = 0; i< requests.length; i++){
            int p1 = findPar(requests[i][0]), p2 = findPar(requests[i][1]);
            
            if(p1 == p2) ans[i] = true;
            else{
                boolean found = false;
                for(int[] rest : restrictions){
                    
                    int pp1 = findPar(rest[0]), pp2 = findPar(rest[1]);
                    if(p1 == pp1 && p2 == pp2 || p1 == pp2 && p2 == pp1){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    ans[i] = true;
                    par[p1] = p2;
                }
            }
        }
        return ans;
    }
}
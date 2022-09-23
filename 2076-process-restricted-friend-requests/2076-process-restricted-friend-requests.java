class Solution {
    
    int[] par ;
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        par = new int[n];
        
        for(int i = 0 ; i < n; i++){
            par[i] = i;
        }
        
        boolean[] ans = new boolean[requests.length];
        
        for(int i = 0 ; i < requests.length; i++){
            int[] rest = requests[i];
            
            int p1 = findPar(rest[0]), p2 = findPar(rest[1]);
            
            boolean flag = false;
            
            for(int[] res : restrictions){
                int pp1 = findPar(res[0]), pp2 = findPar(res[1]);
                
                if(pp1 == p1 && pp2 == p2 || pp1 == p2 && pp2 == p1){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans[i] = true;
                par[p1] = p2;
            }
        }
        return ans;
    }
}
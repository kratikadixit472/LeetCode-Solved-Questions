class Solution {
    
    int[] par, sz;
    
    private void union(int a, int b){
        int p1 = findPar(a), p2 = findPar(b);
        
        if(p1 != p2){
            if(sz[p1] < sz[p2]){
                par[p1] = par[p2];
                sz[p2] += sz[p1];
            }
            else{
               par[p2] = par[p1];
               sz[p1] += sz[p2];
            }
        }
    }
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        par = new int[n+1];
        sz = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            par[i] = i;
            sz[i] = 1;
        }
        
        for(int i = threshold+1; i <= n; i++){
            int j = 1;
            while(j*i <= n){
                union(i, j*i);
                j++;
            }
        }
        
        List<Boolean> ans = new ArrayList<>();
        
        for(int[] q : queries){
            int p1 = findPar(q[0]), p2 = findPar(q[1]);
            if(p1 == p2){
                ans.add(true);
            }
            else ans.add(false);
        }
        
        return ans;
    }
}
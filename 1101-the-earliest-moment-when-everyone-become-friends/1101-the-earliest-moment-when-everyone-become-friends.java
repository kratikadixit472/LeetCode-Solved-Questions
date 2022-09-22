class Solution {
    
    int[] par;
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int earliestAcq(int[][] logs, int n) {
        par = new int[n];
        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        
        
        for(int[] log : logs){
            int time = log[0], x = log[1], y = log[2];
            int p1 = findPar(log[1]), p2 = findPar(log[2]);
            
            if(p1 != p2){
                par[p1] = par[p2];
                n--;
            }
            if(n == 1) return time;
        }
        return -1;
    }
}
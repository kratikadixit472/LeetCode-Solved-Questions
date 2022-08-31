class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int earliestAcq(int[][] logs, int n) {
        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        par = new int[n];
        
        for(int i = 0;  i < n; i++){
            par[i] = i;
        }
        
        int earliestTime = 0;
        
        for(int[] log : logs){
            int p1 = findPar(log[1]), p2 = findPar(log[2]);
            int time = log[0];
            
            if(p1 != p2){
                par[p2] = par[p1];
                earliestTime = time;
            }
        }
        
        int first = findPar(0);
        for(int i = 0; i < n; i++){
            if(findPar(i) != first) return -1;
        }
        
        return earliestTime;
    }
}
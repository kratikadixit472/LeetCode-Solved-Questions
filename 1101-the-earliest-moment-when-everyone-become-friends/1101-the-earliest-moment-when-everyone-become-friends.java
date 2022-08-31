class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int earliestAcq(int[][] logs, int n) {
        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        int groupCount = n;
        
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
                groupCount--;
            }
            if(groupCount == 1) return time;
        }
        
        return -1;
    }
}
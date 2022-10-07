class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int earliestAcq(int[][] logs, int n) {
        
        par = new int[n];
        
        for(int i = 0; i < n; i++) par[i] = i;
        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int earlierTime = Integer.MIN_VALUE;
        
        for(int[] log : logs){
            int x = findPar(log[1]), y = findPar(log[2]);
            
            int time = log[0];
            if(x != y){
                par[x] = par[y];
                n--;
            }
            if(n == 1) return time;
        }
        return -1;
    }
}

/*
[[7,3,1],[2,3,0],[3,2,1],[6,0,1],[0,2,0],[4,3,2]]
4
*/
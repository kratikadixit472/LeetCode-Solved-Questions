class Solution {
    
    int[] par;
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int minimumCost(int n, int[][] connections) {
        
        par = new int[n+1];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int minCost = 0;
        
        for(int[] c : connections){
            int i = c[0], j = c[1], cost = c[2];
            
            int p1 = findPar(i), p2 = findPar(j);
            if(p1 != p2){
                par[p1] = p2;
                minCost += cost;
                n--;
            }
        }
        return (n > 1) ? -1 : minCost;
    }
}
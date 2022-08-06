class Solution {
    int[] size, par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int findCircleNum(int[][] arr) {
        
        int n = arr.length;
        
        par = new int[n];
        for(int i = 0; i <arr.length; i++){ 
            par[i] = i;
        }
        int cnt = n;
        
        for(int i = 0; i< n; i++){
             for(int j = 0; j < arr[0].length; j++){
                 if(arr[i][j] == 1){
                     int p1 = findPar(i), p2 = findPar(j);
                     if(p1 != p2){
                         par[p1] = par[p2];
                         cnt--;
                     }
                 }
             }
        }
        return cnt;
    }
}
class Solution {
    
    int[] par, size;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{1, 0}, {0,1}, {-1, 0}, {0, -1}};
        
        par = new int[n * m];
        size = new int[n * m];
        for(int i = 0; i < m * n ; i++){
            par[i] = i;
            size[i] = 1;
        }
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    
                    int p1 = findPar(i * m + j);
                    
                    for(int[] d : dir){
                        int r = i + d[0];
                        int c = j + d[1];
                        
                        
                        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                            int p2 = findPar(r * m + c);
                            if(p1 != p2){
                                par[p2] = p1;
                                size[p1] += size[p2];
                            }
                        }
                    }
                    max = Math.max(max, size[p1]);
                }
            }
            
        }
        return max;
    }
}
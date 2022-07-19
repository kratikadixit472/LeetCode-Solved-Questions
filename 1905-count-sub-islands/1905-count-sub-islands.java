class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int ans = 0;
        
        int n = grid1.length, m = grid1[0].length;
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    
                    if(DFS(i, j, n, m, grid1, grid2, dir)) ans++;
                }
            }
        }
        
        return ans;
    }
    
    private boolean DFS(int i, int j, int n, int m, int[][] grid1, int[][] grid2, int[][] dir){
        
        
        if(grid1[i][j] != grid2[i][j]) return false;
        boolean result = true;
        grid2[i][j] = -1;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid2[r][c] == 1){
                if(!DFS(r, c, n, m, grid1, grid2, dir)) {
                    result = false;
                }
            }
          
        }
        return result;
    }
}
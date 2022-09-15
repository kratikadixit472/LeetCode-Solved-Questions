class Solution {
    
    int n, m;
    int paths = 0;
    int[][] dir = {{0, 1}, {1,0}, {0,-1}, {-1,0}};
    
    public int uniquePathsIII(int[][] grid) {
        
        n = grid.length; m = grid[0].length;
        
        int nonObstacles = 0;
        int start_row = 0, start_col = 0;
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] >= 0) nonObstacles++;
                if(grid[i][j] == 1){
                    start_row = i;
                    start_col = j;
                }
            }
        }
        explorePossiblePaths(start_row, start_col, nonObstacles, grid);
        
        return paths;
    }
    
    private void explorePossiblePaths(int r, int c, int remain, int[][] grid){
        
        if(grid[r][c] == 2 && remain == 1){
            paths++;
            return;
        }
        
        int tmp = grid[r][c];
        grid[r][c] = -4;
        remain -= 1;
        
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            
            if(nr >= n || nc >= m || nr < 0 || nc < 0 || grid[nr][nc] < 0) continue;
            
            explorePossiblePaths(nr, nc, remain, grid);
            
        }
        grid[r][c] = tmp;
    }
}
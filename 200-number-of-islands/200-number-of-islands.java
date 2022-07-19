class Solution {
    public int numIslands(char[][] grid) {
     int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, n, m, grid, dir);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j,int n, int m, char[][] grid, int[][] dir)
    {
        
        grid[i][j] = '0';
        
        for(int d=0; d<4; d++){
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1'){
                dfs(x, y, n, m, grid, dir);
            }
        }
    }
}
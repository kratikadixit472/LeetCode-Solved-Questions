class Solution {
    
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == '1'){
                    DFS(i, j, n, m, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void DFS(int r, int c, int n, int m, char[][] grid){
        
        grid[r][c] = '0';
        
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            
            if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1'){
                DFS(nr, nc, n, m, grid);
            }
        }
    }
}
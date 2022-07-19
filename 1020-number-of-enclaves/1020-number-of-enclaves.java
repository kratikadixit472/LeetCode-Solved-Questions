class Solution {
    public int numEnclaves(int[][] grid) {
        
        int ans = 0;
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int n = grid.length, m = grid[0].length;
        
        
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1) DFS(i, 0, grid, dir);
            if(grid[i][m-1] == 1) DFS(i, m-1, grid, dir);
        }
        
        for(int i = 0; i < m; i++){
            if(grid[0][i] == 1) DFS(0, i, grid, dir);
            if(grid[n-1][i] == 1) DFS(n-1, i, grid, dir);
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) ans++;
            }
        }
        
        return ans;
    }
    
    private void DFS(int i, int j, int[][] grid, int[][] dir){
        System.out.print(i +" "+ j);
        grid[i][j] = 0;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                DFS(r, c, grid, dir);
            }
        }
    }
}
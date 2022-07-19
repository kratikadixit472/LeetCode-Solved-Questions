class Solution {
    public int numEnclaves(int[][] grid) {
        
        int ans = 0;
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int n = grid.length, m = grid[0].length;
        
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i == 0 || j == 0 || j == m-1 || i == n-1) && grid[i][j] == 1){
                    DFS(i, j, grid, dir);
                }
            }
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
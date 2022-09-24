class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{-1, 0},{1, 0}, {0,-1}, {0, 1}};
        
        int numOfIsland = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    islands_traversal(i, j, n, m, grid, dir);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;
    }
    
    private void islands_traversal(int r, int c, int n, int m, char[][] grid, int[][] dir){
        
        grid[r][c] = '0';
        
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            
            if(isValid(nr, nc, n, m, grid)){
                islands_traversal(nr, nc, n, m, grid, dir);
            }
        }
    }
    
    private boolean isValid(int r, int c, int n, int m, char[][] grid){
        if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '0') return false;
        return true;
    }
}
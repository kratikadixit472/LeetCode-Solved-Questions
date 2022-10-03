class Solution {
    
    int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        DFS(row, col, n, m, grid, grid[row][col]);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] < 0){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void DFS(int row, int col,int n, int m, int[][] mat, int color){
        
        if(row < 0 || col < 0 || row >= n || col >= m || mat[row][col] != color) return;
        
        mat[row][col] = -color;
        
        for(int[] d : dir){
           int newRow = row + d[0];
           int newCol = col + d[1];
           
           DFS(newRow, newCol, n, m, mat, color);
            
        }
        if(row+1 < n && col+1 < m && row > 0 && col > 0 && color == Math.abs(mat[row+1][col]) && color == Math.abs(mat[row][col+1]) && color == Math.abs(mat[row-1][col]) && color == Math.abs(mat[row][col-1])){
            mat[row][col] = color;
        }
    }
}
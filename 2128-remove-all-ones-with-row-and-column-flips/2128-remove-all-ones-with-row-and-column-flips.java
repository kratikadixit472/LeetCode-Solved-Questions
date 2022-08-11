class Solution {
    public boolean removeOnes(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < m; i++){
            if(grid[0][i] == 1) flipCol(i, grid);
        }
        
        for(int i =1; i < n; i++){
            for(int j = 1; j< m; j++){
                if(grid[i][j] != grid[i][j-1]) return false;
            }
        }
        return true;
    }
    
    private void flipCol(int j, int[][] grid){
        
        for(int i = 0; i < grid.length; i++){
            grid[i][j] = 1 - grid[i][j];
        }
    }
}
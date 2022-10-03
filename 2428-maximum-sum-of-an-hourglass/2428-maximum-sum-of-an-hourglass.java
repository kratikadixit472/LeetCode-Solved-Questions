class Solution {
    public int maxSum(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int sum = 0;
        
        for(int i = 0; i < n-2; i++){
            for(int j = 0 ; j < m-2; j++){
                
                sum = Math.max(sum, getMaxSum(i, j, n, m, grid));
                
            }
        }
        return sum;
    }
    
    private int getMaxSum(int i, int j, int n, int m, int[][] grid){
        
        int sum = grid[i][j] + grid[i][j+1]+grid[i][j+2] +
                     grid[i+1][j+1] +
        grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
        
        return sum;
    }
}
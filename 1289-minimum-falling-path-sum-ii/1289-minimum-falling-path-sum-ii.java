class Solution {
    
    int n, m;
    
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        n = matrix.length; m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++) {
            ans = Math.min(ans, minFallPath(0, i, matrix, dp));
        }
        return ans;
    }
    private int minFallPath(int row, int col, int[][] matrix, int[][] dp){
        
        if(col >= m || col < 0) return Integer.MAX_VALUE;
        
        if(row == n-1) return matrix[row][col];
        
        if(dp[row][col] != 0) return dp[row][col];
        
        int min = Integer.MAX_VALUE;
        
        for(int nextCol = 0 ; nextCol < m; nextCol++){
            if(nextCol == col) continue;
            min = Math.min(min, minFallPath(row+1, nextCol, matrix, dp) + matrix[row][col]);
        }
        
        dp[row][col] = min;
        return dp[row][col];
    }
}
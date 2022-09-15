class NumMatrix {

    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n+1][m+1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
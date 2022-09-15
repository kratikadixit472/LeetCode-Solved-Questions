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
        
        int left = minFallPath(row+1, col-1, matrix, dp);
        int mid = minFallPath(row+1, col, matrix, dp);
        int right = minFallPath(row+1, col+1, matrix, dp);
        
        dp[row][col] = Math.min(left, Math.min(mid, right)) + matrix[row][col];
        return dp[row][col];
    }
}
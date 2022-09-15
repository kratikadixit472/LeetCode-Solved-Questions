class Solution {
    
    int n, m;
    
    public int minFallingPathSum(int[][] matrix) {
        
        int ans = Integer.MAX_VALUE;
        n = matrix.length; m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        
        for(int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int nextCol = 0 ; nextCol < m; nextCol++){
                    if(nextCol == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][nextCol] + matrix[i][j]);
                } 
            }
        }
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}
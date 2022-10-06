class Solution {
    public long maxPoints(int[][] points) {
        
        int n = points.length, m = points[0].length;
        long[][] dp = new long[n][m];
        long maxPoints = 0;
        
        for(int j = 0; j < m; j++){
            dp[0][j] = points[0][j];
            // maxPoints = Math.max(maxPoints, points[0][j]);
        }
        
        for(int i = 1; i < n; i++){
            
            long[] left = new long[m];
            long[] right = new long[m];

            left[0] = dp[i-1][0];
            right[m-1] = dp[i-1][m-1];
            
            for(int k = 1; k < m; k++){
                left[k] = Math.max(dp[i-1][k], left[k-1]-1);
            }
            for(int k = m-2 ; k >= 0 ; k--){
                right[k] = Math.max(dp[i-1][k], right[k+1]-1);
            }

            for(int j = 0; j < m; j++){
                dp[i][j] = points[i][j] + Math.max(left[j], right[j]);
            }
        }
        
        for(int j = 0; j < m; j++){
            maxPoints = Math.max(maxPoints, dp[n-1][j]);
        }
    
        return maxPoints;
    }
}
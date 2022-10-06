class Solution {
    public long maxPoints(int[][] points) {
        
        int n = points.length, m = points[0].length;
        long[] dp = new long[m];
        long maxPoints = 0;
        
        for(int j = 0; j < m; j++){
            dp[j] = points[0][j];
        }
        
        for(int i = 1; i < n; i++){
            
            long[] left = new long[m];
            long[] right = new long[m];
            long[] curr = new long[m];

            left[0] = dp[0];
            right[m-1] = dp[m-1];
            
            for(int k = 1; k < m; k++){
                left[k] = Math.max(dp[k], left[k-1]-1);
            }
            for(int k = m-2 ; k >= 0 ; k--){
                right[k] = Math.max(dp[k], right[k+1]-1);
            }

            for(int j = 0; j < m; j++){
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }
            dp = curr;
        }
        
        for(int j = 0; j < m; j++){
            maxPoints = Math.max(maxPoints, dp[j]);
        }
    
        return maxPoints;
    }
}
class Solution {
    public long maxPoints(int[][] points) {
        
        int n = points.length, m = points[0].length;
        
        long[] dp = new long[m];
        
        for(int i = 0; i < points[0].length; i++){
            dp[i] = points[0][i];
        }
        long maxAns = dp[0];
        
        for(int i = 0; i < n-1; i++){
            long[] curr = new long[m];
            long[] right = new long[m];
            long[] left = new long[m];
            
            left[0] = dp[0];
            right[m-1] = dp[m-1];
            
            for(int j = 1; j < m; j++){
                left[j] = Math.max(dp[j], left[j-1]-1); 
            }
            for(int j = m-2; j >= 0; j--){
                right[j] = Math.max(dp[j], right[j+1]-1); 
            }
            for(int j = 0; j < m; j++){
                curr[j] = points[i+1][j] + Math.max(left[j], right[j]); 
            }
            dp = curr;
        }
        
        for(int j = 0; j < m; j++){
            maxAns = Math.max(maxAns, dp[j]);
        }
        return maxAns;
    }
}
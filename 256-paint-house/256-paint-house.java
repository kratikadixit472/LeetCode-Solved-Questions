class Solution {
    public int minCost(int[][] costs) {
        
        int n = costs.length;
        int[][] dp = new int[n][3];
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < 3; i++){
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                
                if(j == 0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j+2]); 
                }
                else if(j == 1) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j+1]); 
                }
                else{
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j-2]); 
                }
            }
            
        }
        
        for(int k = 0; k < 3; k++){
            ans = Math.min(dp[n-1][k], ans);
        }
        
        return ans;
    }
}
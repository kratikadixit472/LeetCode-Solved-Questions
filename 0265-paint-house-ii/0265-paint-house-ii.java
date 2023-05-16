class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length, m = costs[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++){
            dp[0][i] = costs[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int min = Integer.MAX_VALUE;
                
                for(int k = 0; k < m; k++){
                    if(j != k){
                        min = Math.min(min, dp[i-1][k]);
                    }
                }
                
                dp[i][j] = min + costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++){
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}
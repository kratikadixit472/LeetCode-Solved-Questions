class Solution {
    public int minCost(int[][] costs) {
        
        return getMinCost(0, 0, costs);
        
    }
    
    private int getMinCost(int row, int col, int[][] costs){
        
        int n = costs.length, m = costs[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++){
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j == 0)
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j+2]);
                else if(j == 1)
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j-1]);
                else
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j-2]);
            }
        }
        int totalMinCost = Integer.MAX_VALUE;
        
        for(int i = 0; i < 3; i++){
            totalMinCost = Math.min(totalMinCost, dp[n-1][i]);
        }
        return totalMinCost;
    }
}
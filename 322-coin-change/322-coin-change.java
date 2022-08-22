class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int ans = countAll(coins, amount, 0);
            
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
    
    private int countAll(int[] coins, int total, int idx){
        
        int n = coins.length;
        
        int[][] dp =new int[n][total+1];
        
        for(int i = 0 ; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0 ; i < n; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= total; j++){
                if(i > 0) dp[i][j] = dp[i-1][j];
                
                if(coins[i] <= j && dp[i][j-coins[i]] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]] + 1);
                }
            }
        }
        return dp[n-1][total] == Integer.MAX_VALUE ? -1 : dp[n-1][total];
    }
}
class Solution {
    public int maxProfit(int[] prices, int fee) {
        return maximizeProfit(prices, new int[prices.length+2][2], fee);
    }
    
    private int maximizeProfit(int[] prices, int[][] dp, int fee){
        
        int n = prices.length;
        
        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    dp[idx][buy] = Math.max(-prices[idx] + dp[idx+1][0], 0 + dp[idx+1][1]);
                }
                else dp[idx][buy] = Math.max(prices[idx] + dp[idx+1][1] - fee, 0 + dp[idx+1][0]);
            }
        }
        return dp[0][1];
    }
}
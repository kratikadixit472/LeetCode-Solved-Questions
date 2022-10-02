class Solution {
    public int maxProfit(int[] prices) {
        return maximizeProfit(0, 1, prices, new Integer[prices.length][2]);
    }
    private int maximizeProfit(int idx, int buy, int[] prices, Integer[][] dp){
        
        if(idx >= prices.length) return 0;
        
        if(dp[idx][buy] != null) return dp[idx][buy];
        
        if(buy == 1){
            return dp[idx][buy] = Math.max(-prices[idx] + maximizeProfit(idx+1, 0, prices, dp), maximizeProfit(idx+1, 1, prices, dp));
        }
        
        return dp[idx][buy] = Math.max(prices[idx] + maximizeProfit(idx+2, 1, prices, dp), maximizeProfit(idx+1, 0, prices, dp));
    }
}
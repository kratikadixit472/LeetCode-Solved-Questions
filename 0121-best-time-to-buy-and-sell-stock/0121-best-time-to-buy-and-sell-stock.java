class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0, lp = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lp){
                lp = prices[i];
            }
            profit = Math.max(profit, prices[i] - lp);
        }
        return profit;
    }
}
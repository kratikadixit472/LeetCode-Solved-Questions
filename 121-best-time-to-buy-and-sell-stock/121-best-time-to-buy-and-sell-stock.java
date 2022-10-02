class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE, profit = 0;
        
        for(int i = 0; i < prices.length; i++){
            
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            else{
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }
}
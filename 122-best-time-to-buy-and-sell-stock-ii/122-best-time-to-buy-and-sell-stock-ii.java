class Solution {
    public int maxProfit(int[] prices) {
        
        int sell = -1, buy = -1, profit = 0;
        
        for(int i = 0 ; i < prices.length; i++){
            while(i+1 < prices.length && prices[i] >= prices[i+1]){
                i++;
            }
            buy = prices[i];
            
            while(i+1 < prices.length && prices[i] <= prices[i+1]){
                i++;
            }
            sell = prices[i];
            
            profit += sell - buy;
        }
        return profit;
    }
}
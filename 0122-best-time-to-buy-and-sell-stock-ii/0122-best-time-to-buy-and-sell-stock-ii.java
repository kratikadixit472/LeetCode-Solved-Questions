class Solution {
    public int maxProfit(int[] prices) {
        
        int sell = -1, buy = -1, profit = 0;
        int n = prices.length, i = 0;
        
        while(i < n-1){
            
            if(i+1 < n && prices[i] >= prices[i+1]){
                i++;
            }
            buy = prices[i];

            if(i+1 < n && prices[i] <= prices[i+1]){
                i++;
            }
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;
    }
}
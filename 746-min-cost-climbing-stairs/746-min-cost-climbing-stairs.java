class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n];
        
        for(int i = 0 ; i < n; i++){
            if(i <= 1){
                dp[i] = cost[i];
                continue;
            }
            
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-2], dp[n-1]);
    }
}
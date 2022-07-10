class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        
        return Math.min(findMin(cost, 0, dp), findMin(cost, 1, dp));
    }
    
    private int findMin(int[] cost, int idx, int[] dp){
        if(idx >= cost.length) return 0;
        
        if(idx == cost.length-1) return cost[idx];
        
        if(dp[idx] != -1) return dp[idx];
        
        int first = findMin(cost, idx + 1, dp); 
        int second = findMin(cost, idx + 2, dp); 
        
        dp[idx] =  Math.min(first, second) + cost[idx];
        
        return dp[idx];
    }
}
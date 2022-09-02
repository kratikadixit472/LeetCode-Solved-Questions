class Solution {
    public int climbStairs(int n) {
        
        if(n <= 2) return n;
        
        int[] dp = new int[n+1];
        
        for(int i = 0; i<=n; i++){
            if(i <= 2) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
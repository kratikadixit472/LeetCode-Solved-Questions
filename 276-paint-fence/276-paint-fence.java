class Solution {
    public int numWays(int n, int k) {
        return findWaysToPaint(n, k, new Integer[n+1]);
    }
    private int findWaysToPaint(int n, int k, Integer[] dp){
        
        if(n == 1) return k;
        if(n == 2) return k * k;
        
        if(dp[n] != null) return dp[n];
        
        return dp[n] = (k-1) * (findWaysToPaint(n-1, k, dp) + findWaysToPaint(n-2, k, dp));
    }
}
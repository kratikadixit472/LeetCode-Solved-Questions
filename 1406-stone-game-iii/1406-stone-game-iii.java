class Solution {
    
    int notComputed = 1000000000;
    int[] dp;
    
    public String stoneGameIII(int[] stoneValue) {
        
       int n = stoneValue.length;
        dp = new int [n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = notComputed;
        }
        int dif = helper(stoneValue, stoneValue.length, 0);
        if (dif > 0) {
            return "Alice";
        }
        if (dif < 0) {
            return "Bob";
        }
        return "Tie";
    }
    
    private int helper(int[] stoneValue, int n, int i) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != notComputed) {
            return dp[i];
        }
        dp[i] = stoneValue[i] - helper(stoneValue, n, i + 1);
        if (i + 2 <= n) {
            dp[i] = Math.max(dp[i], stoneValue[i]
                + stoneValue[i + 1] - helper(stoneValue, n, i + 2));
        }
        if (i + 3 <= n) {
            dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1]
                + stoneValue[i + 2] - helper(stoneValue, n, i + 3));
        }
        return dp[i];
    }
}
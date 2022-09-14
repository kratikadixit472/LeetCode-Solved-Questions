class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int ans = 0, n = values.length;
        int[] dp = new int[n];
        dp[0] = 0;
        
        for(int i = 1; i < values.length; i++){
            dp[i] = Math.max(dp[i-1], values[i-1] + i - 1);
            ans = Math.max(ans, values[i] + dp[i] - i);
        }
        return ans;
    }
}
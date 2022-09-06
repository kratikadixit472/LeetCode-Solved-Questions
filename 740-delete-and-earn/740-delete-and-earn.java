class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] sum = new int[10001];
        int[] dp = new int[10001];
        
        for(int num : nums){
            sum[num] += num;
        }
        
        dp[0] = 0; dp[1] = sum[1];
        
        for(int i = 2; i < 10001; i++){
            dp[i] = Math.max(dp[i-2] + sum[i], dp[i-1]);
        }
        return dp[10000];
    }
}
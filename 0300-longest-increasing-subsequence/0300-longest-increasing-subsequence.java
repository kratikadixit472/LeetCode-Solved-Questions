class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 0;
        int[] dp = new int[nums.length];
        
        for(int i = 0 ; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
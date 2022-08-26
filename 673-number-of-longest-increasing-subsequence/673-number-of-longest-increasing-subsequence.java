class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        
        int[] dp = new int[n]; 
        int[] cnt = new int[n];
        
        int maxLen = 0, ans = 0;
        
        for(int i = 0; i < n; i++){
            dp[i] = cnt[i] = 1;
            for(int j = 0 ; j < i; j++){
                if(nums[i] > nums[j]){
                    
                    if(dp[i] == dp[j] + 1) cnt[i] += cnt[j];
                    else if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            
            if(maxLen == dp[i]) ans += cnt[i];
            if(maxLen < dp[i]){
                maxLen = dp[i];
                ans = cnt[i];
            }
        }
        return ans;
    }
}
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n = nums.length;
        int[] incr = new int[n];
        int[] decr = new int[n];
        
        LIS(nums, incr, n);
        LDS(nums, decr, n);
        
        
        int ans = 0;
        
        for(int i = 0 ; i <n; i++){
            if(incr[i] > 1 &&  decr[i] > 1) ans = Math.max(ans, incr[i] + decr[i] - 1);
        }
        return n - ans;
    }
    
    private void LDS(int[] nums, int[] dp, int n){
        
        for(int i = n-1; i >= 0; i--){
            dp[i] = 1;
            for(int j = i; j < n; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
    private void LIS(int[] nums, int[] dp, int n){
        
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
}
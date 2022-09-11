class Solution {
    
    int ans = 0;
    
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int i = 1; i <= target; i++){
            for(int ele : nums){
                if(i - ele >= 0){
                    dp[i] += dp[i - ele];
                }
            }
        }
        return dp[target];
    }
}
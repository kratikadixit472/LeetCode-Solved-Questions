class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
         
        for(int tar = 0; tar <= target; tar++){
            for(int num : nums){
                if(tar >= num){
                    dp[tar] += dp[tar - num];
                }
            }
            
        }
        return dp[target];
    }
}
class Solution {
    public int rob(int[] nums) {
        
        return findMaxMoney(0, nums, new Integer[nums.length]);
    }
    private int findMaxMoney(int idx, int[] nums, Integer[] dp){
        
        if(idx >= nums.length) return 0;
        
        if(dp[idx] != null) return dp[idx];
        
        int takeIt = nums[idx] + findMaxMoney(idx+2, nums, dp);
        int notTakeIt = findMaxMoney(idx+1, nums, dp);
        
        return dp[idx] = Math.max(takeIt, notTakeIt);
    }
}
class Solution {
    public int maximumScore(int[] nums, int[] mul) {
        
        return findMaxMul(0, 0, nums, mul, new int[mul.length][mul.length]);
    }
    
    private int findMaxMul(int idx, int left, int[] nums, int[] mul, int[][] dp){
        
        if(idx == mul.length)return 0;
        
        if(dp[idx][left] != 0) return dp[idx][left];
        
        int right = nums.length - 1 - (idx - left); 
        
        int mult = mul[idx];
        
        dp[idx][left] = Math.max(nums[right] * mult + findMaxMul(idx+1, left, nums, mul, dp), nums[left] * mult + findMaxMul(idx+1, left+1, nums, mul, dp));
        
        return dp[idx][left];
    }
}

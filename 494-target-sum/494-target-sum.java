class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        
        for(int ele : nums) sum += ele;
        
        int[][] dp = new int[n][2*sum + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return helper(nums, target+sum, sum, 0, dp);
    }
    
    private int helper(int[] nums, int target, int sum, int idx, int[][] dp){
        
        if(idx == nums.length) return target == sum ? 1 : 0;
        if(idx >= nums.length) return 0;
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        
        int pos = helper(nums, target, sum - nums[idx] , idx + 1, dp);
        int neg = helper(nums, target, sum + nums[idx] , idx + 1, dp);
        
        dp[idx][sum] = pos + neg;
        
        return dp[idx][sum];
    }
}

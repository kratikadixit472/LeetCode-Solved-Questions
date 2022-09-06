class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Arrays.sort(nums);
        
        return solve(nums, 0, new int[nums.length]);
    }
    
    private int solve(int[] nums, int i, int[] dp){
        
        if(i >= nums.length){
            return 0;
        }
        
        if(dp[i] != 0) return dp[i];
        
        int currVal = nums[i];
        int currSum = nums[i];
        int index = i + 1;
        
        while(index < nums.length && currVal == nums[index]){
            currSum += nums[index];
            index++;
        }
        while(index < nums.length && currVal + 1 == nums[index]){
            index++;
        }
        
        dp[i] = Math.max(currSum + solve(nums, index, dp), solve(nums, i+1, dp));
        
        return dp[i];
    }
}
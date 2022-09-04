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

/*
private int dp(int i, int left) {
        if (i == m) {
            return 0; // Base case
        }

        int mult = multipliers[i];
        int right = n - 1 - (i - left);
            
        if (memo[i][left] == 0) {
            // Recurrence relation
            memo[i][left] = Math.max(mult * nums[left] + dp(i + 1, left + 1), 
                                     mult * nums[right] + dp(i + 1, left));
        }

        return memo[i][left];
    }
*/
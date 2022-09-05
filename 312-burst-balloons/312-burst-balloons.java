class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length + 2;
        
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        int[][] dp = new int[n][n];
        newNums[0] = 1;
        newNums[n-1] = 1;
        
        return getMaxCoins(1, n-2, newNums, dp);
    }
    
    private int getMaxCoins(int left, int right, int[] nums, int[][] dp){
        
        if(right - left < 0) return 0;
        
        if(dp[left][right] > 0) return dp[left][right];
        
        int result = 0;
        
        for(int i = left ; i <= right ; i++){
            
            int last = nums[left-1] * nums[i] * nums[right+1];
            
            int remaining = getMaxCoins(left, i-1, nums, dp) + getMaxCoins(i+1, right, nums, dp);
            
            result = Math.max(result, last + remaining);
        }
        
        return dp[left][right] = result;
    }
}
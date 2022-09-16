class Solution {
    public int maximumScore(int[] nums, int[] mul) {
        
        int m = mul.length, n = nums.length;
        int[][] dp = new int[m+1][n+1]; 
        
        for(int i = m-1; i >= 0; i--){
            for(int left = i; left >= 0; left--){
                dp[i][left] = Math.max(nums[left] * mul[i] + dp[i+1][left+1], nums[n-1-(i - left)] * mul[i] + dp[i+1][left]);
            }
        }
           
        return dp[0][0];
    }
}

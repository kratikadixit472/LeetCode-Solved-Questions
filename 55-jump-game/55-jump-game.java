class Solution {
    public boolean canJump(int[] nums) {
        
        return ifYouCanJump(nums, new boolean[nums.length]);
    }
    private boolean ifYouCanJump(int[] nums, boolean[] dp){
        
        dp[nums.length-1] = true;
        
        for(int pos = nums.length-2 ; pos >= 0; pos--){
            int furtherJump = Math.min(pos + nums[pos], nums.length-1);
            for(int nextPos = pos+1; nextPos <= furtherJump; nextPos++){
                if(dp[nextPos] == true){
                    dp[pos] = dp[nextPos];
                    break;
                }
            }
        }
        return dp[0];
    }
}
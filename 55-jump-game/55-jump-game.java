class Solution {
    public boolean canJump(int[] nums) {
        
        return ifYouCanJump(0, nums, new int[nums.length]);
    }
    private boolean  ifYouCanJump(int pos, int[] nums, int[] dp){
        if(pos == nums.length-1)  {
            dp[pos] = 1;
            return true;
        }
        
        int furtherJump = Math.min(pos + nums[pos], nums.length-1);
        
        if(dp[pos] != 0) return dp[pos] == 1 ? true : false;
        
        boolean res = false;
        
        for(int nextPos = pos+1; nextPos <= furtherJump; nextPos++){
            
            res = res || ifYouCanJump(nextPos, nums, dp);
        }
        dp[pos] = res == true ? 1 : -1;
        
        return res;
    }
}
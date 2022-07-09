class Solution {
    public boolean canJump(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return canJumpFromPosition(0, nums, dp);
    }
    
    private boolean canJumpFromPosition(int position, int[] nums, int[] dp){
        
        if(position == nums.length-1) return true;
        
        if(dp[position] != -1) {
            
            return dp[position] == 1;
        }
        
        int furthestJump = Math.min(position + nums[position], nums.length-1);
        
        for(int nextPosition = furthestJump ; nextPosition > position ; nextPosition--){
            if(canJumpFromPosition(nextPosition, nums, dp)) {
                dp[nextPosition] = 1;
                return true;
            }
        }
        dp[position] = 0;
        return false;
    }
}
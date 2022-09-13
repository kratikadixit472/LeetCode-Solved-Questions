class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 20000);
        return ifYouCanJump(nums, dp);
    }
    
    private int ifYouCanJump(int[] nums, int[] dp){

        dp[nums.length-1] = 0;

        for(int pos = nums.length-2 ; pos >= 0; pos--){
            int furtherJump = Math.min(pos + nums[pos], nums.length-1);
            for(int nextPos = pos+1; nextPos <= furtherJump; nextPos++){

                dp[pos] = Math.min(1 + dp[nextPos], dp[pos]);

            }
        }
        return dp[0];
    }
}
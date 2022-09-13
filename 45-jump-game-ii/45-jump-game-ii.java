class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 20000);
        return ifYouCanJump(0, nums, dp);
    }
    private int ifYouCanJump(int pos, int[] nums, int[] dp){
        if(pos >= nums.length-1)  {
            // dp[pos] = 0;
            return 0;
        }
        
        int furtherJump = Math.min(pos + nums[pos], nums.length-1);
        
        if(dp[pos] != 20000) return dp[pos] ;
        
        int res = 20000;
        
        for(int nextPos = pos+1; nextPos <= furtherJump; nextPos++){
            // if(nums[nextPos] == 0) continue;
            res = Math.min(res, 1 + ifYouCanJump(nextPos, nums, dp));
        }
        dp[pos] = res;
        
        return res ;
    }
    
//         private int ifYouCanJump(int[] nums, boolean[] dp){

//             dp[nums.length-1] = true;

//             for(int pos = nums.length-2 ; pos >= 0; pos--){
//                 int furtherJump = Math.min(pos + nums[pos], nums.length-1);
//                 for(int nextPos = pos+1; nextPos <= furtherJump; nextPos++){

//                     dp[pos] = Math.min(dp[nextPos], dp[pos]);

//                 }
//             }
//             return dp[0];
//         }
}
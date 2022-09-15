class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int[] d : dp) Arrays.fill(d, -1);
        return 1 + Math.max(getWiggle(0, nums, 1, dp), getWiggle(0, nums, -1, dp));
    }
    
    private int getWiggle(int idx, int[] nums, int isUp, int[][] dp){
        
        int maxVal = 0;
        int j = (isUp == 1) ? 1 : 0;
        
        if(dp[idx][j] != -1) return dp[idx][j];
        
        for(int i = idx + 1; i < nums.length; i++){
            if(isUp == 1 && nums[idx] < nums[i] || isUp == -1 && nums[idx] > nums[i]){
                maxVal = Math.max(maxVal, 1 + getWiggle(i, nums, -isUp, dp));
            }
        }
        return dp[idx][j] = maxVal;
    }
}
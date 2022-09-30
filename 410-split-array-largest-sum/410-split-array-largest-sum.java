class Solution {
    
    
    public int splitArray(int[] nums, int m) {
        
        int n = nums.length;
        int[] preSum = new int[n+1];
        
        for(int i = 0; i < n; i++){
            preSum[i+1] = nums[i] + preSum[i];
        }
        
        return getLargestSum(0, preSum, nums, m, new Integer[n][m+1]);
    }
    
    private int getLargestSum(int currIdx, int[] pref, int[] nums, int m, Integer[][] dp){
        
        int n = pref.length-1;
        
        if(m == 1) return pref[n] - pref[currIdx];
        
        if(dp[currIdx][m] != null) return dp[currIdx][m];
        
        int minLargestSum = Integer.MAX_VALUE;
        for(int i = currIdx; i <= n - m ; i++){
            
            int firstSum = pref[i+1] - pref[currIdx];
            
            int largestSum = Math.max(firstSum, getLargestSum(i+1, pref, nums, m-1, dp));
            
            minLargestSum = Math.min(minLargestSum, largestSum);
            
            if(firstSum >= minLargestSum) break;
        }
        return dp[currIdx][m] = minLargestSum;
    }
}
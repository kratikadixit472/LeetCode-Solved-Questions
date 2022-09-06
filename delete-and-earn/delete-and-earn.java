class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] sum = new int[10001];
        // int[] dp = new int[10001];
        
        for(int num : nums){
            sum[num] += num;
        }
        
        // dp[0] = 0; dp[1] = sum[1];
        
        int incl = sum[1], excl = sum[0];
        
        for(int i = 2; i < 10001; i++){
            int max = Math.max(excl + sum[i], incl);
            excl = incl;
            incl = max;
        }
        return incl;
    }
}
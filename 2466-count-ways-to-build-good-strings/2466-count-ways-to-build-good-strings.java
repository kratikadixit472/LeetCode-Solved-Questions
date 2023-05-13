class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int[] dp = new int[high + 1];
        int m = (int)(1e9 + 7);
        dp[0] = 1;
        
        for(int i = 1 ; i <= high; i++){
            if(i - zero >= 0){
                dp[i] += dp[i - zero];
            }
            if(i - one >= 0){
                dp[i] += dp[i - one];
            }
            
            dp[i] %= m;
        }
        
        int ans = 0;
        
        for(int i = low; i <= high; i++){
            ans += dp[i];
            ans %= m;
        }
        return ans;
    }
}
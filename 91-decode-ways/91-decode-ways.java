class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1];
        
        for(int i = n; i>=0; i--){
            if(i == n) {
                dp[i] = 1;
                continue;
            }
            
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            
            dp[i] += dp[i+1];
            
            if(i < n - 1){
                int sec = Integer.valueOf(s.substring(i, i+2));
                if(sec <= 26){
                    dp[i] += dp[i+2];
                }
            }
        }
        
        return dp[0];
    }
}
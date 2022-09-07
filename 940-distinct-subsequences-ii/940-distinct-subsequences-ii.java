class Solution {
    public int distinctSubseqII(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1];
        int[] last = new int[26];
        
        
        Arrays.fill(last, -1);
        int ans = 0, mod = (int) 1e9 + 7;
        dp[0] = 1;
        
        for(int i = 0; i < n; i++){
            int ch = s.charAt(i) - 'a';
            
            dp[i+1] = (2 * dp[i]) % mod;
            if(last[ch] >= 0){
                dp[i+1] -= dp[last[ch]];
            }
            dp[i+1] %= mod;
            last[ch] = i;
        }
        dp[n]--;
        
        if(dp[n] < n) return dp[n] + mod;
        return dp[n];
    }
}
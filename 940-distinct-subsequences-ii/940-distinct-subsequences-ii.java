class Solution {
    public int distinctSubseqII(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        int ans = 0, mod = (int) 1e9 + 7;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i] += dp[j];
                    dp[i] = dp[i] % mod;
                }
            }
            ans += dp[i];
            ans = ans % mod;
        }
        
        return ans;
    }
}
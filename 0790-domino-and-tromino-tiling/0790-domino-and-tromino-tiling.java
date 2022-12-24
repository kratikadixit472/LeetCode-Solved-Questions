class Solution {
    public int numTilings(int n) {
        
        if(n <= 1) return n;
        
        long[] dp = new long[n+1];
        dp[0] = 1; dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <=n; i++){
            dp[i] = (2 * dp[i-1] + dp[i-3]) % (int)(1e9 + 7);
        }
        return (int)dp[n] ;
    }
}
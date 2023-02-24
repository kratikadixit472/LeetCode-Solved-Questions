class Solution {
    public int numberOfWays(int numPeople) {
        
        long[] dp = new long[numPeople / 2 + 1];
        long mod = 1000000007;
        dp[0] = 1;
        
        for(int i = 1; i <= numPeople / 2; i++){
            for(int j = 0; j < i; j++){
                dp[i] += (dp[j] * dp[i - j - 1]) % mod;
                dp[i] %= mod;
            }
        }
        return (int)dp[numPeople / 2];
    }
}
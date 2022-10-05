class Solution {
    
    public int numSquares(int n) {
        
        return countSquares(n, new Integer[n+1]);
    }
    
    private int countSquares(int n, Integer[] dp){
        
        if(n <= 3) return n;
        if(dp[n] != null) return dp[n];
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i*i <= n; i++){
            ans = Math.min(ans, 1 + countSquares(n - i*i, dp));
        }
        return dp[n] = ans;
    }
}
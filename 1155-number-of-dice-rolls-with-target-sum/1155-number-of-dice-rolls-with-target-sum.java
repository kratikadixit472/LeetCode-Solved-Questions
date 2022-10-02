class Solution {
    
    int mod = (int)(1e9 + 7);
    
    public int numRollsToTarget(int n, int k, int target) {
        return getTargetSum(0, 0, n, k, target);
    }
    
    private int getTargetSum(int dice, int sum, int n, int K, int target){
        
        int[][] dp = new int[n+1][target+1];
        
        dp[0][0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                if(j > i * K) continue;
                else{
                    
                    for(int k = 1; k <= K; k++){
                        if(k <= j){
                            dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % mod;
                        }
                    }
                }
            }
        }
        return dp[n][target];
    }
}
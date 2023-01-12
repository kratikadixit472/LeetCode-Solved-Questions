class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(),  m = t.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                
                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                
                if(i < j){
                    dp[i][j] = 0;
                    continue;
                }
                
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        int maxLen = 0;
      
        for(int i = 1; i <=n ; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen; 
    }
}
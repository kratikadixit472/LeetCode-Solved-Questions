class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return longestCommon(text1, text2, new int[text1.length()+1][text2.length()+1]);
    }
    
    private int longestCommon(String s1, String s2, int[][] dp){
        
        int n = s1.length(), m = s2.length();
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
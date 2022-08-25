class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int[][] dp = new int[s.length()][s.length()];

        int n = s.length();
        
        for(int gap = 0; gap < n; gap++){
            for(int j = gap, i = 0; j < n; j++, i++){
                
                if(i > j || i == j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }
                
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
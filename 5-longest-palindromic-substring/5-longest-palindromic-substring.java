class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxS = 0, si = -1, ei = -1;
        
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){
                if(i == j || gap == 0){
                    dp[i][j] = 1;
                    // continue;
                }
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                if(dp[i][j] > maxS){
                    si = i; ei = j;
                    maxS = dp[i][j];
                }
            }
        }
        
        return s.substring(si, ei+1);
    }
}
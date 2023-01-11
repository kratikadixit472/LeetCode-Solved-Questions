class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int si = -1, ei = -1, len = 0;
        
        for(int gap = 0 ; gap < n ; gap++){
            for(int i = 0, j = gap ; j < n; i++, j++){
                
                if(gap == 0){
                    dp[i][j] = 1;
                }
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                if(len < dp[i][j]){
                    si = i;
                    ei = j;
                    len = dp[i][j];
                }
            }
        }
        return s.substring(si, len + si);
    }
}
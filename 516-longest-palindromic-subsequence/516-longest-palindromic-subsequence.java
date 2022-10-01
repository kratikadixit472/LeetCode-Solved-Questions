class Solution {
    public int longestPalindromeSubseq(String s) {
        
        return longestPalindrome(0, s.length()-1, s, new Integer[s.length()][s.length()]);
    }
    private int longestPalindrome(int i, int j, String s, Integer[][] dp){
        
        if(i > j || i >= s.length() || j < 0) return 0;
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(i == j && s.charAt(i) == s.charAt(j)) return 1;
        
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + longestPalindrome(i+1, j-1, s, dp);
        }
        
        return dp[i][j] = Math.max(longestPalindrome(i+1, j, s, dp), longestPalindrome(i, j-1, s, dp));
    }
}
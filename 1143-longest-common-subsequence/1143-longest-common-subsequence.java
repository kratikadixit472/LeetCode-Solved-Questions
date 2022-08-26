class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return helper(text1, text2, 0, 0, text1.length(), text2.length(), new int[text1.length()][text2.length()]);
    }
    
    private int helper(String s1, String s2, int i, int j, int n, int m, int[][] dp){
        
        if(i == n || j == m) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] =  1 + helper(s1, s2, i+1, j+1, n, m, dp);
        }
        
        else{
            int c1 = helper(s1, s2, i+1, j, n, m, dp);
            int c2 = helper(s1, s2, i, j+1, n, m, dp);
            dp[i][j] = Math.max(c1, c2);
        }
        
        return dp[i][j]; 
    }
}
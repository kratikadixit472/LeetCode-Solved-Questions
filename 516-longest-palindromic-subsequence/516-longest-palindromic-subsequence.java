class Solution {
    public int longestPalindromeSubseq(String s) {
        
        return findLongest(s, 0, s.length()-1, new int[s.length()][s.length()]);
    }
    
    private int findLongest(String s, int l, int r, int[][] dp){
        
        if(l > r) return 0;
        
        if(l == r) return 1;
        
        if(dp[l][r] != 0) return dp[l][r];
        
        if(s.charAt(l) == s.charAt(r)){
            dp[l][r] = 2 + findLongest(s, l+1, r-1, dp);
        }
        
        else{
            int c1 = findLongest(s, l+1, r, dp);
            int c2 = findLongest(s, l, r-1, dp);

            dp[l][r] = Math.max(c1, c2);
        }
        return dp[l][r];
    }
}
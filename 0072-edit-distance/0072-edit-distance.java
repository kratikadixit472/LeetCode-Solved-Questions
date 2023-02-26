class Solution {
    public int minDistance(String word1, String word2) {
        return getMinDistance(0, 0, word1.length(), word2.length(), word1, word2, new Integer[word1.length()][word2.length()]);
    }
    
    private int getMinDistance(int i, int j, int n, int m, String s1, String s2, Integer[][] dp){
        
        if(i == n) return m - j;
        if(j == m) return n - i;
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = getMinDistance(i+1, j+1, n, m, s1, s2, dp);
        }
        
        int replace = getMinDistance(i+1, j+1, n, m, s1, s2, dp);
        int delete = getMinDistance(i+1, j, n, m, s1, s2, dp);
        int insert = getMinDistance(i, j+1, n, m, s1, s2, dp);
        
        return dp[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
    }
}
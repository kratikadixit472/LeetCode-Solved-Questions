class Solution {
    public int countSubstrings(String s) {
        
        if(s == null || s.length() <= 1) return s.length();
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        int ans = 0;
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int j = gap, i = 0; j < s.length(); j++, i++){
                
                if(gap == 0) dp[i][j] = true;
                
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
                
                if(dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        String pp = removeStar(p);
        int n = s.length(), m = pp.length();
        
        Integer[][] dp = new Integer[n+1][m+1];
        int ans = isMatch(n, m, s, pp, dp);
        return ans == 1;
    }
    private int isMatch(int n, int m, String s, String t, Integer[][] dp){
        
        if(m == 0 || n == 0){
            if(m == 0 && n == 0) dp[n][m] = 1;
            else if(m == 1 && t.charAt(m-1) == '*') dp[n][m] = 1;
            else dp[n][m] = 0;
        }
        
        if(dp[n][m] != null) return dp[n][m];
        
        char ch1 = s.charAt(n-1);
        char ch2 = t.charAt(m-1);
        
        if(ch1 == ch2 || ch2 == '?'){
            return dp[n][m] = isMatch(n-1, m-1, s, t, dp);
        }
        
        else if(ch2 == '*'){
            boolean res = false;
            res = res || isMatch(n-1, m, s, t, dp) == 1;
            res = res || isMatch(n, m-1, s, t, dp) == 1;
            
            return dp[n][m] = res ? 1 : 0;
        }
        else{
            return dp[n][m] = 0;
        }
    }
    private String removeStar(String s){
        if(s.length() <= 0) return s;
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        
        int i = 1;
        while(i < s.length()){
            while(i < s.length() && s.charAt(i) == '*' && sb.charAt(sb.length()-1) == '*')
                i++;
            
            if(i < s.length()) 
                sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
class Solution {
    public boolean isInterleave(String a, String b, String c) {
        
        int m = b.length();
            int n = a.length();
            boolean dp[][] = new boolean[n+1][m+1];
            
            if(m+n != c.length()) return false;
            
            for(int i=0; i<=n; i++){
                for(int j=0; j<=m; j++){
                    
                    if(i == 0 && j == 0){
                        dp[i][j] = true;
                    }
                    
                    else if(i == 0){
                        
                        dp[i][j] = dp[i][j-1] && b.charAt(j-1) == c.charAt(i+j-1);
                        
                    }
                    
                    else if(j == 0){
                        dp[i][j] = dp[i-1][j] && a.charAt(i-1) == c.charAt(i+j-1);
                    }
                    
                    else{
                        dp[i][j] = ((dp[i-1][j] && a.charAt(i-1) == c.charAt(i+j-1)) || (dp[i][j-1] && b.charAt(j-1) == c.charAt(i+j-1)));
                    }
                }
            }
            
            return dp[n][m];
    }
}
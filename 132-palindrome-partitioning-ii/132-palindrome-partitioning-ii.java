class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        boolean[][] pdp = new boolean[n][n];
        Integer[] dp = new Integer[n];
        
        for(int gap = 0; gap < n; gap++){
            for(int j = gap, i= 0 ; j < n; j++,i++){
                
                if(gap == 0) pdp[i][j] = true;
                
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    pdp[i][j] = true;
                }
                
                else if(s.charAt(i) == s.charAt(j) && pdp[i+1][j-1]){
                    pdp[i][j] = true;
                }
            }
        }
        return getAllPartitions(s, 0, n-1, dp, pdp);
        
    }
    
    private int getAllPartitions(String s, int l, int r, Integer[] dp, boolean[][] pdp){
        
        if(pdp[l][r]) return 0;
        
        if(dp[l] != null) return dp[l];
        
        int minCut = (int)1e9;
        for(int i = l ; i <= r; i++){
            if(pdp[l][i]){
                
                minCut = Math.min(minCut, 1 + getAllPartitions(s, i+1, r, dp, pdp));
            }
        }
        dp[l] = minCut;
        
        return dp[l];
    }
    
//     private boolean isPalindrome(String s, int l, int r){
        
//         while(l < r){
//             if(s.charAt(l++) != s.charAt(r--)) return false;
//         }
//         return true;
        
//     }
}
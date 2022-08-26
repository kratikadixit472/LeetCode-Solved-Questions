class Solution {
    public int minCut(String s) {
        
        return getAllPartitions(s, 0, s.length()-1, new int[s.length()][s.length()]);
        
    }
    
    private int getAllPartitions(String s, int l, int r, int[][] dp){
        
        if(l >= r || isPalindrome(s, l, r)) return 0;
        
        int minCut = r - l;
        
        if(dp[l][r] != 0) return dp[l][r];
        
        for(int i = l ; i <= r; i++){
            if(isPalindrome(s, l, i)){
                
                minCut = Math.min(minCut, 1 + getAllPartitions(s, i+1, r, dp));
            }
        }
        dp[l][r] = minCut;
        
        return dp[l][r];
    }
    
    private boolean isPalindrome(String s, int l, int r){
        
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
        
    }
}
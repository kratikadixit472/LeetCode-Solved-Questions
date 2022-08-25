class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() <= 1) return s;
        
        int[][] dp = new int[s.length()][s.length()];
        int maxlen = 0, ei = -1, si = -1;
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int j=gap, i = 0; j < s.length(); j++, i++){
                
                if(gap == 0) dp[i][j] = 1;
                
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                if(dp[i][j] > maxlen){
                    si = i;
                    ei = j;
                    maxlen = dp[i][j];
                }
            }
        }
        // for(int i = 0; i < s.length(); i++){
        //     for(int j = 0; j < s.length(); j++){
        //         System.out.print(dp[i][j] +" ");
        //     }
        //     System.out.println();
        // }
        
        return s.substring(si, ei+1);
    }
}
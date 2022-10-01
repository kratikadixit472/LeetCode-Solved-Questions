class Solution {
    public int numDecodings(String s) {
        
        return countAllPossible(s);
    }
    
    private int countAllPossible(String s){
        int[] dp = new int[s.length() + 1];
        
        for(int i = s.length(); i >= 0; i--){
            if(i == s.length()){
                dp[i] = 1;
                continue;
            }
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i+1];
            
            if(i < s.length()-1){
                int sec = Integer.valueOf(s.substring(i, i+2));
                if(sec <= 26) {
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
/*
1. string of numbers
2. we have 2 sigle digit(1-9) and double digit(10 - 26)
*/
class Solution {
    
    int mod = (int) (1e9 + 7);
    
    public int numDecodings(String s) {
        
        long[] dp = new long[s.length()+1];
        Arrays.fill(dp, -1);
        
        findAllPossible(0, s.length(), s, dp);
        return  (int)dp[0];
    }
    
    private long findAllPossible(int idx, int n, String s, long[] dp){
        
        if(idx == n) {
            dp[idx] = 1;
            return 1;
        }
        
        if(dp[idx] != -1) return dp[idx];
        if(s.charAt(idx) == '0'){
            dp[idx] = 0;
            return dp[idx];
        }
        
        char ch = s.charAt(idx);
        
        long count = 0;
        
        if(ch == '*'){
            count = (count + 9 * findAllPossible(idx+1, n, s, dp)) % mod;
            
            if(idx < n-1){
                char ch1 = s.charAt(idx+1);
                if(ch1 >= '0' && ch1 <= '6'){
                    count = (count + 2 * findAllPossible(idx+2, n, s, dp)) % mod;
                }
                else if(ch1 >= '7' && ch1 <= '9'){
                    count = (count + 1 * findAllPossible(idx+2, n, s, dp)) % mod;
                }
                else{
                    count = (count + 15 * findAllPossible(idx+2, n, s, dp)) % mod;
                }
            }
        }
        else{
            count = count + (1 * findAllPossible(idx+1, n, s, dp)) % mod;
            if(idx < n-1){
                char ch1 = s.charAt(idx+1);
                if(ch1 == '*'){
                    if(ch == '1'){
                        count = (count + 9 * findAllPossible(idx+2, n, s, dp)) % mod;
                    }
                    else if(ch == '2'){
                        count = (count + 6 * findAllPossible(idx+2, n, s, dp)) % mod;
                    }
                }
                else{
                    int num = (ch - '0' )*10 +  ch1 - '0';
                    if(num <= 26) count = (count +findAllPossible(idx+2, n, s, dp)) % mod;
                }
            }
        }
        dp[idx] = count;
        
        return dp[idx] ;
    }
}
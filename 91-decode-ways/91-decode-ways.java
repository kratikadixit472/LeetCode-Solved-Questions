class Solution {
    public int numDecodings(String s) {
        return getAllWays(0, s, s.length(), new int[s.length()]);
    }
    
    private int getAllWays(int idx, String s, int n, int[] dp){
        
        if(idx == n) return 1;
        if(s.charAt(idx) == '0') return 0;
        
        if(dp[idx] != 0) return dp[idx];
        
        int left = s.charAt(idx) -'0';
        // System.out.println(left+" "+ s.charAt(idx));
        int total = 0;
        if(left <= 9 && left > 0){
            total = getAllWays(idx+1, s, n, dp); 
        }
        if(idx + 2 <= n){
        
            int right = Integer.valueOf(s.substring(idx, idx+2));
            // System.out.println(right+" "+ s.substring(idx, idx+2));
            if(right <= 26 && right >= 10){
                total += getAllWays(idx+2, s, n, dp);
            }
        }
        dp[idx] = total;
        return dp[idx];
    }
}
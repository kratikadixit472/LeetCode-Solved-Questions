class Solution {
    public int longestIdealString(String s, int k) {
        
        int[] dp = new int[26];
        int ans = 1;
        //Arrays.fill(dp, 1);
        
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            dp[idx] = dp[idx] + 1;
            for(int j = Math.max(0, idx - k); j <= Math.min(25, idx + k); ++j){
                
                if(j != idx) dp[idx] = Math.max(dp[idx], dp[j] + 1);
                
            }
            ans = Math.max(ans, dp[idx]);
        }
        return ans;
    }
}

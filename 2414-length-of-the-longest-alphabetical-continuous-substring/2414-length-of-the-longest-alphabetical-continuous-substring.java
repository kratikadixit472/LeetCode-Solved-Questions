class Solution {
    public int longestContinuousSubstring(String s) {
        
        int n = s.length();
        int left = 0;
        char prev = s.charAt(0);
        int ans = 0;
        
        if(n == 1) return 1;
        
        for(int right = 1; right < n; right++){
            char curr = s.charAt(right);
            
            if(curr - prev != 1){
                prev = curr;
                left = right;
            }
            prev = curr;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
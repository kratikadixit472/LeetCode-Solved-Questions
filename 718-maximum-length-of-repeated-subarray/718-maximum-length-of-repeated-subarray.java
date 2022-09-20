class Solution {
    
    public int findLength(int[] nums1, int[] nums2) {
        
        return longestCommonSubstring(nums1, nums2);
        
    }
    private int longestCommonSubstring(int[] nums1, int[] nums2){
        int n = nums1.length, m = nums2.length, ans = 0;
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}


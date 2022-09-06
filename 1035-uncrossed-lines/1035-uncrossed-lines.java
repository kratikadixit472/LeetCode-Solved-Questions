class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        return getLIS(0, 0, nums1, nums2, new Integer[nums1.length][nums2.length]);
    }
    private int getLIS(int i, int j, int[] nums1, int[] nums2, Integer[][] dp){
        
        if(i >= nums1.length || j >= nums2.length) return 0;
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(nums1[i] == nums2[j]){
            return dp[i][j] = (1 + getLIS(i+1, j+1, nums1, nums2, dp));
        }
        else{
            return dp[i][j] = Math.max(getLIS(i+1, j, nums1, nums2, dp), getLIS(i, j+1, nums1, nums2, dp));
        }
    }
}
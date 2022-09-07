class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        int n = nums1.length, m = nums2.length;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] d: dp) Arrays.fill(d, -(int)(1e9));
        
        return getMaxProd(n, m, nums1, nums2, dp);
        
    }
    
    private int getMaxProd(int n, int m, int[] nums1, int[] nums2, int[][] dp){
        
        if(n == 0 || m == 0) return dp[n][m] = -(int) (1e8);
        
        if(dp[n][m] != -(int)(1e9)) return dp[n][m];
        
        int val = nums1[n-1] * nums2[m-1];
        int acceptBothNumbers = getMaxProd(n-1, m-1, nums1, nums2, dp) + val;
        int a = getMaxProd(n-1, m, nums1, nums2, dp);
        int b = getMaxProd(n, m-1, nums1, nums2, dp);
        
        dp[n][m] = getMax(val, acceptBothNumbers, a, b);
        
        return dp[n][m];
    }
    
    private int getMax(int... arr){
        int max = arr[0];
        for(int ele : arr){
            max = Math.max(max, ele);
        }
        return max;
    }
}
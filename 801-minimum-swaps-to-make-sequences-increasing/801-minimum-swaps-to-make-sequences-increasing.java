class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        return getMinSwap(0, nums1, nums2, -1, -1, 0, new Integer[nums1.length][2]);
    }
    
    private int getMinSwap(int idx, int[] num1, int[] num2, int preva, int prevb, int swap, Integer[][] dp){
        
        if(idx == num1.length) return 0;
        if(dp[idx][swap] != null) return dp[idx][swap];
        
        int minSwap = Integer.MAX_VALUE;
        
        if(preva < num1[idx] && prevb < num2[idx]){
            minSwap = getMinSwap(idx+1, num1, num2, num1[idx], num2[idx], 0, dp);
        }
        
        if(prevb < num1[idx] && preva < num2[idx]){
            minSwap = Math.min(minSwap, 1 + getMinSwap(idx+1, num1, num2, num2[idx], num1[idx], 1, dp));
        }
        
        return dp[idx][swap] = minSwap;
    }
}
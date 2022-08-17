class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k <= 1) return 0;
        
        int prod = 1, ans = 0;
        int j = 0;
        
        for(int i = 0; i < nums.length; i++){
            prod *= nums[i];
            
            while(j <= i && prod >= k){
                prod = prod / nums[j++];
            }
            ans += (i - j + 1);
        }
        return ans;
        
    }
}
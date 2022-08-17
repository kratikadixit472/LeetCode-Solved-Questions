class Solution {
    public int maxProduct(int[] nums) {
        
        int min = nums[0], max = nums[0];
        int ans = nums[0];
        
        for(int i = 1 ; i < nums.length; i++){
            
            int temp = max;
            
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], temp * nums[i]));
            
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
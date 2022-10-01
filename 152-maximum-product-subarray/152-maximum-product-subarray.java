class Solution {
    public int maxProduct(int[] nums) {
        
        int min = nums[0], max = nums[0], maxProd = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            
            int tmp = max;
            
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * tmp, nums[i] * min));
            
            maxProd = Math.max(maxProd, max);
        }
        return maxProd;
    }
}
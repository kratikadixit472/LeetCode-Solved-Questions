class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        if(n <= 0) return 0;
        
        int min = nums[0], max = nums[0];
        int ans = max;
        
        for(int i = 1; i < n; i++){
            int tmp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tmp * nums[i], min * nums[i]));
            ans = Math.max(ans, Math.max(max, min));
            
        }
        return ans;
    }
}
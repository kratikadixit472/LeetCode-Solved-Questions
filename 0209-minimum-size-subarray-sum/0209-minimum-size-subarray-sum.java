class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length, left = 0;
        int ans = Integer.MAX_VALUE, sum = 0;
        
        for(int right = 0; right < n ; right++){
            sum += nums[right];
            while(sum >= target) {
                ans = Math.min(ans, right - left + 1);

                sum -= nums[left++];
            }
            
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        int ans = 0, zero = 0;
        
        for(right = 0; right < n; right++){
            if(nums[right] == 0){
                zero++;
            }
            while(zero > 1){
                zero -= (nums[left] == 0 ? 1 : 0);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
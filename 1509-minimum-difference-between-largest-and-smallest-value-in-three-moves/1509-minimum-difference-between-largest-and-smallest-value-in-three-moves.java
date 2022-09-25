class Solution {
    public int minDifference(int[] nums) {
        
        int n = nums.length;
        if(n < 5) return 0;
        
        Arrays.sort(nums);
        int left_3_2 = Math.min(nums[n-1] - nums[3], nums[n-2] - nums[2]);
        int right_3_2 = Math.min(nums[n-4] - nums[0], nums[n-3] - nums[1]);
        return Math.min(left_3_2, right_3_2);
    }
}
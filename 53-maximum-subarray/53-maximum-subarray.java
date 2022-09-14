class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0], currentSum = nums[0];

        for(int i = 1 ; i < nums.length; i++){
            currentSum += nums[i];
            currentSum = Math.max(nums[i], currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;
        int cicularSum = kadanes(nums, n);
        
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
            nums[i] = -nums[i];
        }
        
        int minSum = kadanes(nums, n);
        
        int nonCicularSum = totalSum + minSum;
        if(nonCicularSum <= 0) return cicularSum;
        
        return Math.max(cicularSum, nonCicularSum);
    }
    
    private int kadanes(int[] nums, int n){
        int maxSum = nums[0], currSum = nums[0];
        
        for(int i =1; i < n; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
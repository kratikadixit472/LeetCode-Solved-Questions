class Solution {
    
    private int minimumSubArraysRequired(int[] nums, int maxSumAllowed){
        
        int splitRequired = 0, sum = 0;
        
        for(int ele : nums){
            
            if(sum + ele <= maxSumAllowed){
                sum += ele;
            }
            else{
                
                sum = ele;
                splitRequired++;
            }
        }
        return splitRequired + 1;
    }
    public int splitArray(int[] nums, int m) {
        
        int n = nums.length;
        int left = 0, right = 0;
        
        for(int i = 0; i < n; i++){
            left = Math.max(nums[i], left);
            right += nums[i];
        }
        
        int minLargestSplitSum = 0;
        
        while(left <= right){
            
            int maxSumAllowed = (left + right) / 2;
            
            if(minimumSubArraysRequired(nums, maxSumAllowed) <= m){
                minLargestSplitSum = maxSumAllowed;
                right = maxSumAllowed - 1;
            }
            else{
                left = maxSumAllowed +1;
            }
        }
        return minLargestSplitSum;
    }
}
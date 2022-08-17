class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int left = 0, count = 0, sum = 0;
        int[] presum = new int[nums.length + 1];
        presum[0] = 1;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            int target = sum - goal;
            if(target >= 0 && presum[target] > 0) count += presum[target];
            presum[sum] += 1;
        }
        
        return count;
    }
}
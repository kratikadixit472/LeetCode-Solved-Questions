class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0);
    }
    
    private int helper(int[] nums, int target, int idx){
        
        if(target == 0 && idx == nums.length) return 1;
        if(idx >= nums.length) return 0;
        
        int pos = helper(nums, target - nums[idx] , idx + 1);
        int neg = helper(nums, target + nums[idx] , idx + 1);
        
        return pos + neg;
    }
}
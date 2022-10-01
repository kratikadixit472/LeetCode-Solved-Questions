class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int take = nums[0], notTake = 0;
        
        for(int i = 1; i < n; i++){
            
            int max = Math.max(take, notTake+nums[i]);
            notTake = take;
            take = max;
        }
        return take;
    }
}
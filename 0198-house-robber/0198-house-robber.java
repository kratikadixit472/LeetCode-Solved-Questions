class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int take = nums[0], notTake = 0;
        
        for(int i = 1; i < n; i++){
            int tmp = Math.max(take, nums[i] + notTake);
            notTake = take;
            take = tmp;
        }
        return take;
    }
}
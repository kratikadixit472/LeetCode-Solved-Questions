class Solution {
    public int binarySearchableNumbers(int[] nums) {
        
        int searchable = 0, n = nums.length;
        int min_r = Integer.MAX_VALUE, max_l = Integer.MIN_VALUE;
        
        boolean[] leftMax = new boolean[n];
        
        for(int i = 0; i < n; i++){
            leftMax[i] = max_l < nums[i];
            max_l = Math.max(max_l, nums[i]);
        }
        
        for(int i = n-1; i >= 0; i--){
            searchable += ((leftMax[i]) && nums[i] < min_r) ? 1 : 0;
            min_r = Math.min(min_r, nums[i]);
        }
        return searchable;
    }
}
class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int curr = Math.abs(nums[i]);
            if(nums[curr] < 0) return curr;
            nums[curr] = -nums[curr];
        }
        return -1;
    }
}
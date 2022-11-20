class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length, small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(nums[i] <= small) small = nums[i];
            else if(nums[i] <= big) big = nums[i];
            else return true;
        }
        return false;
    }
}
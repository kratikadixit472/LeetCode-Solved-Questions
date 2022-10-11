class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        int small = Integer.MAX_VALUE, greater = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(small >= nums[i]){
                small = nums[i];
            }
            else if(greater >= nums[i]){
                greater = nums[i];
            }
            else return true;
        }
        return false;
    }
}
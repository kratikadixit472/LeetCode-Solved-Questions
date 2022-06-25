class Solution {
    public boolean checkPossibility(int[] nums) {
        
        if(nums.length <= 1) return true;
        int cnt = 0;
        
        for(int i = 1 ;  i < nums.length; i++){
            if(nums[i-1] > nums[i]) {
                cnt++;
                if(cnt > 1 || (i-1 > 0 && nums[i-2] > nums[i] &&  i+1 < nums.length && nums[i-1] > nums[i+1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
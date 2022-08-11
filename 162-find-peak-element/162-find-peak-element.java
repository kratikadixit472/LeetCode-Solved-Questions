class Solution {
    public int findPeakElement(int[] nums) {
        
        int l = 0, n = nums.length;
        
        int ans = 0;
        
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]) ans = i;
        }
        if(ans == 0 && n > 1){
            if(nums[n-1] > nums[n-2]) ans = nums.length - 1;
            else ans = 0;
        }
        return ans;
    }
}
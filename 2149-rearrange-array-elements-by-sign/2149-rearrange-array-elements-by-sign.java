class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        
        int[] ans = new int[n];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                ans[idx] = nums[i];
                idx += 2;
            }
        }
        
        idx = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                ans[idx] = nums[i];
                idx += 2;
            }
        }
        
        return ans;
    }
}
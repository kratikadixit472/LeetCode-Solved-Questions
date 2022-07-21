class Solution {
    public int missingElement(int[] nums, int k) {
        
        int ans = 0, prev = 0;
        
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1] - 1;
            if(diff >= k) return nums[i-1] + k;
            k -= diff;
        }
         
        return nums[nums.length-1] + k;
    }
}
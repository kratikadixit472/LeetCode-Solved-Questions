class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        int left = 0, right = 0;
        long maxflag = -1, minflag = -1, ans = 0;
        
        for(right = 0; right < nums.length; right++){
            
            if(nums[right] < minK || nums[right] > maxK){
                if(nums[right] < minK) minflag = -1;
                else maxflag = -1;
                left = right + 1;
            }
            
            if(nums[right] == minK || nums[right] == maxK){
                if(nums[right] == minK) minflag = right;
                if(nums[right] == maxK) maxflag = right;
            }
            
            ans += Math.max(0, Math.min(minflag, maxflag) - left + 1);
        }
        return ans;
    }
}
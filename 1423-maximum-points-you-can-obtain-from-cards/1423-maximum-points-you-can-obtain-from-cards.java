class Solution {
    public int maxScore(int[] nums, int k) {
        
        int i = 0, j = nums.length-1, ans = 0;
        int lsum = 0;
        
        for(i = 0; i < k; i++){
            lsum += nums[i];
        }
        
        ans = lsum;
        
        for(i = k-1; i >= 0; i--){
            
            lsum = lsum - nums[i] + nums[j];
            ans = Math.max(lsum, ans);
            j--;
        }
        return ans;
    }
}
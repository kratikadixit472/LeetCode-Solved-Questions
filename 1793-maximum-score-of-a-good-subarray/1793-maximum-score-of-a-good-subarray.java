class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int l = k, r = k, n = nums.length;
        int min = Integer.MAX_VALUE, ans = 0;
        if(n == 1) return nums[0];
        
        while(l > 0 || r < n-1){
            
            if(l == 0) r++;
            
            else if(r == n-1) l--;
            
            else if(nums[l-1] > nums[r+1]) l--;
            
            else r++;
            
            min = Math.min(min, Math.min(nums[l], nums[r]));
            ans = Math.max(ans, min * (r - l + 1));
        }
        return ans;
    }
}

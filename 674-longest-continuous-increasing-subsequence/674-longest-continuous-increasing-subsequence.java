class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int n = nums.length;
        
        if(n == 1) return 1;
        
        int cnt = 1, ans = 0;
        
        for(int i = 0; i < n-1; i++){
            if(nums[i] < nums[i+1]) cnt++;
            
            else{
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        // if(nums[n-2] < nums[n-1]) cnt++;
        
        return Math.max(ans, cnt);
    }
}
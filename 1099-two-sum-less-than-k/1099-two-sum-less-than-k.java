class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        
        Arrays.sort(nums);
        int ans = -1;
        
        int l = 0, r = nums.length-1;
        while(l < r){
            
            int sum = nums[l] + nums[r];
            if(sum < k){
                ans = Math.max(sum, ans);
                l++;
            }
            else r--;
        }
        return ans;
    }
}
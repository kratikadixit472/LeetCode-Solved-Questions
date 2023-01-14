class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, ans = 0, left = 0, cnt = 0, k = 1;
        
        for(int right = 0; right < n; right++){
            cnt += nums[right];
            
            while(left < n && right - left - cnt + 1 > k){
                cnt -= nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
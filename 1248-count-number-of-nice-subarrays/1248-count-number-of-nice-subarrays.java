class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return subarrayK(nums, k) - subarrayK(nums, k-1);

    }
    
    private int subarrayK(int[] nums, int k){
        
        int left = 0, ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            k -= nums[i] % 2;
            
            while(k < 0){
                k += nums[left++] % 2;
            }
            ans += (i - left + 1);
        }
        return ans;
    }
}
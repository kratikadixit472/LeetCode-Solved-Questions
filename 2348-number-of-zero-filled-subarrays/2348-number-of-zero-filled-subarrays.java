class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long ans = 0, zero = 0;
        
        for(int num : nums){
            if(num == 0) zero++;
            else zero = 0;
            ans += zero;
        }
        return ans;
    }
}
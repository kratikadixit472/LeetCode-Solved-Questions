class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int j =0 ;
        int min = Integer.MAX_VALUE, sum = 0;
        
        for(int i=0; i<n; i++){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min, i-j+1);
                sum -= nums[j++];
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
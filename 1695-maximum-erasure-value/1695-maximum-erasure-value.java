class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int sum = 0, max = 0, i = 0,  j = 0;
        
        boolean[] set = new boolean[10001];
        
        while(i < nums.length && j<nums.length){
            
            if(!set[nums[j]]){
                sum += nums[j];
                max = Math.max(max, sum);
                set[nums[j++]] = true;
            }
            else{
                sum = sum - nums[i];
                set[nums[i++]] = false;
            }
        }
        return max;
    }
}
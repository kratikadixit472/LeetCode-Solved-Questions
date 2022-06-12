class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int sum = 0, max = 0, i = 0,  j = 0;
        
        Set<Integer> set = new HashSet<>();
        
        while(i < nums.length && j<nums.length){
            
            if(!set.contains(nums[j])){
                sum += nums[j];
                max = Math.max(max, sum);
                set.add(nums[j++]);
            }
            else{
                sum = sum - nums[i];
                set.remove(nums[i++]);
            }
        }
        return max;
    }
}
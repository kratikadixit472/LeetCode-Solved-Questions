class Solution {
    public int minOperations(int[] nums, int x) {
        
        int target = -x;
        
        for(int ele : nums) target += ele;
        
        if(target == 0) return nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            if(map.containsKey(sum - target)){
                max = Math.max(max, i - map.get(sum-target));
            }
            map.put(sum, i);
        }
        
        return (max != Integer.MIN_VALUE) ? nums.length - max : -1;
    }
}
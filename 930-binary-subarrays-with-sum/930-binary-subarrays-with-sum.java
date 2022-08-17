class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int left = 0, count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            
            int target = sum - goal;
            if(map.containsKey(target)) count += map.get(target);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
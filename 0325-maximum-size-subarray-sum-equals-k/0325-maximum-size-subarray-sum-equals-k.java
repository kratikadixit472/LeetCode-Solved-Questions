class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return ans;
    }
}
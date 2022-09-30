class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){
            sum = (sum + nums[i]) % k;

            if(sum < 0) sum += k;
            ans += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
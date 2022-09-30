class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0) rem += k;
            ans += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }
}
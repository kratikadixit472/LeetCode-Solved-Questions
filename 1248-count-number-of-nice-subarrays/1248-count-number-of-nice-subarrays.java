class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int odd = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){
            odd += nums[i] % 2;
            ans += map.getOrDefault(odd - k, 0);
            map.put(odd, map.getOrDefault(odd, 0)+1);
        }
        return ans;
    }
}
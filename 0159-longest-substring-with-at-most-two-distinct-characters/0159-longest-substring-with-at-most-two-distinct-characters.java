class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] nums = s.toCharArray();
        
        int ans = 0, n = nums.length, k = 2;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, i = 0;

        for(j = 0; j < n; j++){
           
            if(map.getOrDefault(nums[j], 0) == 0) k--;
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            while(k < 0){
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if(map.get(nums[i]) == 0) k++;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
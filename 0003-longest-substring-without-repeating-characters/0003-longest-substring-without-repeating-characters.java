class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(left < right && map.get(s.charAt(right)) > 1){
                char ch1 = s.charAt(left);
                map.put(ch1, map.getOrDefault(ch1, 0) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
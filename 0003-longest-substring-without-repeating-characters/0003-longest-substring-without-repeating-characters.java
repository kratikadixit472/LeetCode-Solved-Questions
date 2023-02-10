class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int n = s.length(), left = 0, ans = 0;
        
        for(int right = 0 ; right < n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while(map.get(c) > 1){
                char ch = s.charAt(left);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if(map.get(ch) == 0) map.remove(ch);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), left = 0;
        int ans = 0;
        
        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.size() > 2){
                char c = s.charAt(left++);
                if(map.containsKey(c)){
                    map.put(c, map.getOrDefault(c, 0) - 1);
                    
                    if(map.get(c) == 0) map.remove(c);
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
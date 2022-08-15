class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int maxSub = 0, start = 0;
        
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.get(ch) > 1){
                map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                start++;
            }
            
            maxSub = Math.max(maxSub, end - start + 1);
        }
        return maxSub;
    }
}
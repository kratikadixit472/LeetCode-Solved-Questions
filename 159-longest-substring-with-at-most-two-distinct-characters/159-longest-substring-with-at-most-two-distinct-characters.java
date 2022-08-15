class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int longSub = Integer.MIN_VALUE, start = 0;
        
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.size() > 2){
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                start++;
            }
            
            longSub = Math.max(longSub, end - start + 1);
        }
        return longSub;
    }
}
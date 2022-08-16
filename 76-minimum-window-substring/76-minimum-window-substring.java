class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length()) return "";
        
        int startIdx = 0, minWind = Integer.MAX_VALUE, matched = 0, left = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if(map.get(ch) >= 0) matched++;
            }
            
            while(matched == t.length()){
                if(minWind > right - left + 1){
                    minWind = right - left + 1;
                    startIdx = left;
                }
                
                char c = s.charAt(left++);
                if(map.containsKey(c)){
                    if(map.get(c) == 0) matched--;
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        }
        
        return (minWind > s.length()) ? "" : s.substring(startIdx, startIdx + minWind);
    }
}
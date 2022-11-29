class Solution {
    public String minWindow(String s, String t) {
        
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int matched = t.length();
        
        int ansLen = Integer.MAX_VALUE, si = -1, ei = -1;
        
        for(right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.getOrDefault(c, 0) - 1);
                if(map.get(c) >= 0) matched--;
            }
            while(matched == 0){
                
                if(ansLen > right - left + 1){
                    ansLen = right - left + 1;
                    si = left; ei = right;
                }
                char ch = s.charAt(left++);
                if(map.containsKey(ch)){
                    if(map.get(ch) == 0) matched++;
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
            }
        }
        if(ansLen > s.length()) return "";
        
        return s.substring(si, si + ansLen);
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
        }
        int matched = 0, j = 0;
        
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0)-1);
                if(map.get(ch) == 0) matched ++;
            }
            if(matched == map.size()) return true;
            
            if(i >= s1.length()-1){
                char c = s2.charAt(j++);
                if(map.containsKey(c)){
                    if(map.get(c) == 0) matched--;
                    map.put(c, map.getOrDefault(c, 0)+1);
                }
            }
        }
        
        return false;
    }
}
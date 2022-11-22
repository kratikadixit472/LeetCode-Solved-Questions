class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        int left = 0, matched = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if(map.get(ch) == 0) matched++;
            }
            if(matched == map.size()) {
                ans.add(left);
                //left = right;
                //matched = 0;
            }
            if(right >= p.length()-1){
                char c = s.charAt(left);
                left++;
                if(map.containsKey(c)){
                    if(map.get(c) == 0) matched--;
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        }
        
        return ans;
    }
}
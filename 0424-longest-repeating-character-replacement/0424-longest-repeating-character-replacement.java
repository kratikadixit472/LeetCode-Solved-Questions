class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0, n = s.length();
        int ans = 0, repeat = 0;
        
        for(right = 0 ; right < n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            repeat = Math.max(repeat, map.get(c));
            
            while(right - left + 1 - repeat > k){
                char cc = s.charAt(left++);
                map.put(cc, map.getOrDefault(cc, 0) - 1);
                if(map.get(cc) == 0){
                    map.remove(cc);
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
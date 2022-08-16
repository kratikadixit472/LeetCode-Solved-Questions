class Solution {
    public int characterReplacement(String s, int k) {
        
        int max = 0, left = 0;
        int repeat = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int right = 0; right < s.length() ; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            repeat = Math.max(repeat, map.get(ch));
            
            if(right - left + 1 - repeat > k ){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
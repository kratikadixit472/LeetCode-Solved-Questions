class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = 0;
        
        for(int i = 0; i <s.length(); i++){
            
            char ch = s.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            while(map.size() > k){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                   j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
                   
        return maxLen ;
    }
}
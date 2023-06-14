class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();
        int left = 0, right = 0, res = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(right = 0; right < n; right++){
            
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            while(map.get(s.charAt(right)) > 1){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            
            if(right - left + 1 == k) {
                res++;
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }
        return res;
    }
}
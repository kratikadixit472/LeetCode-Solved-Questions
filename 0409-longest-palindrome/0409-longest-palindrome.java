class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int ans = 0;
        
        for(char key : map.keySet()){
            ans += (map.get(key) / 2) * 2;
            if(ans % 2 == 0 && map.get(key) % 2 == 1){
                ans += 1;
            }
        }
        return ans;
    }
}
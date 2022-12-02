class Solution {
    public int calculateTime(String keyboard, String word) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < keyboard.length(); i++){
            map.put(keyboard.charAt(i), i);
        }
        
        int prev = 0, ans = 0;
        
        for(int i = 0; i < word.length(); i++){
            int curr = map.get(word.charAt(i));
            ans += Math.abs(prev - curr);
            prev = curr;
        }
        return ans;
    }
}
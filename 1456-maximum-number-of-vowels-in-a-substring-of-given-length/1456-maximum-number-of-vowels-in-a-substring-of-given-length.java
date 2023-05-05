class Solution {
    public int maxVowels(String s, int k) {
        
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        
        int cnt = 0;
        
        for(int i = 0; i < k; i++){
            cnt += set.contains(s.charAt(i)) ? 1 : 0;
        }
        
        int ans = cnt;
        
        for(int i = k; i < s.length(); i++){
            cnt += set.contains(s.charAt(i)) ? 1 : 0;
            cnt -= set.contains(s.charAt(i - k)) ? 1 : 0;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}

//s = "abciiidef", k = 3

// cnt = 1, ans = 1
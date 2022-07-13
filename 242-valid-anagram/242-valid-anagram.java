class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        int[] frq = new int[26];
        
        for(int i = 0; i < s.length() ; i++){
            frq[s.charAt(i) - 'a']++;
            frq[t.charAt(i) - 'a']--;
        }
        
        for(int i = 0 ; i < 26; i++){
            if(frq[i] != 0) return false;
        }
        
        return true;
    }
    
}
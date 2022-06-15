class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        int[] diff = new int[26];
        int cnt = 0;
        
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if(cnt > 2) return false;
                
                diff[s1.charAt(i) - 'a']++;
                diff[s2.charAt(i) - 'a']--;
            }
        }
        
        for(int i=0; i<26; i++){
            if(diff[i] != 0) return false;
        }
        return true;
        
    }
}
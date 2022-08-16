class Solution {
    public int firstUniqChar(String s) {
        
        int[] frq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            frq[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(frq[ch - 'a'] == 1) return i;
        }
        return -1;
    }
}
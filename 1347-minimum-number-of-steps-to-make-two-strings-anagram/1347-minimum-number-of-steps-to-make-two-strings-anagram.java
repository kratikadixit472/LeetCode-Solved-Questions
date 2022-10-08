class Solution {
    public int minSteps(String s, String t) {
        
        int[] frq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            frq[s.charAt(i) - 'a']++;
        }
        
        for(char ch : t.toCharArray()){
            frq[ch-'a']--;
        }
        
        int ans = 0;
        
        for(int i = 0; i < 26; i++){
            ans += frq[i] > 0 ? frq[i] : 0;
        }
        return ans;
    }
}
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(char ch : s1.toCharArray()) cnt1[ch-'a']++;
        for(char ch : s2.toCharArray()) cnt2[ch-'a']++;
        
        return checkBreak(cnt1, cnt2) || checkBreak(cnt2, cnt1);
    }
    
    private boolean checkBreak(int[] strong, int[] weak){
        
        int diff = 0;
        
        for(int i=25; i>=0; i--){
            diff += strong[i] - weak[i];
            if(diff < 0) return false;
        }
        return true;
    }
}
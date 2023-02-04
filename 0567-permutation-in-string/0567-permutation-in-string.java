class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        
        for(int i = 0; i+n <= m; i++){
            if(check(s2.substring(i, i+n), s1)) return true;
        }
        return false;
    }
    
    private boolean check(String s1, String s2){
        int[] frq = new int[26];
        
        for(char c : s1.toCharArray()){
            frq[c-'a']++;
        }
        for(char c : s2.toCharArray()){
            frq[c-'a']--;
        }
        
        for(int i : frq){
            if(i != 0) return false;
        }
        return true;
    }
}
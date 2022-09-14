class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length() <= 0) return true;
        
        int j = 0;
        if(s.length() > t.length() || s == null) return false;
        
        for(int i = 0; i < t.length(); i++){
            if(j >= s.length()) return true;
            char ch1 = s.charAt(j), ch2 = t.charAt(i);
            if(ch1 == ch2){
                j++;
            }
        }
        return (j == s.length());
    }
}
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        int n = s.length(), m = t.length();
        
        if(n > m) return isOneEditDistance(t, s);
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                
                if(n == m) return (s.substring(i+1)).equals(t.substring(i+1));
                
                else return (s.substring(i)).equals(t.substring(i+1));
            }
        }
        return (n + 1 == m);
    }
}
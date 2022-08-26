class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        int i = 0, j = 0;
        int cnt = 0;
        int n = s.length(), m = t.length();
        
        if(Math.abs(n - m) > 1) return false;
        
        
        while(i < n && j < m && s.charAt(i) == t.charAt(i)){
            i++;
            j++;
        }
        
        if(i == n && j == m) return false;
        
        if(n > m) {
            return s.substring(i+1).equals(t.substring(j));
        }
        
        else if(n < m) {
            return s.substring(i).equals(t.substring(j+1));
        }
        
        else {
            return s.substring(i+1).equals(t.substring(j+1));
        }
    }
}
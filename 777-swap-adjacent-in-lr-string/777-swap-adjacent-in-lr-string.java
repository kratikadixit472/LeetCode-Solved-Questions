class Solution {
    public boolean canTransform(String start, String end) {
        
        char[] s = start.toCharArray();
        char[] t = end.toCharArray();
        
        int n = s.length, m = t.length;
        int i = 0, j = 0;
        
        while(i < n || j < m){
            
            while(i < n && s[i] == 'X') i++;
            while(j < m && t[j] == 'X') j++;
            
            if(i == n && j == m) return true;
            if(i == n || j == m) return false;
            
            if(s[i] != t[j]) return false;
            
            if(s[i] == 'L' && i < j) return false;
            if(s[i] == 'R' && i > j) return false;
            
            i++; j++;
        }
        return true;
    }
}
class Solution {
    public boolean canChange(String start, String target) {
        
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        
        if(start.length() != target.length()) return false;
        
        int i = 0, j = 0, n = target.length();
        
        while(i <= n && j <= n){
            
            while(i < n && s[i] == '_') i++;
            while(j < n && t[j] == '_') j++;
            
            if(i == n || j == n) return (i == n && j == n);
            
            if(s[i] != t[j]) return false;
            
            if(s[i] == 'L' && i < j) return false;
            if(s[i] == 'R' && j < i) return false;
            
            i++; j++;
        }
        return true;
    }
}
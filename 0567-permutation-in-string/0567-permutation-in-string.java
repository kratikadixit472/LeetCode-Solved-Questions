class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        if(m < n) return false;
        
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        
        for(char c : s1.toCharArray()){
            f1[c-'a']++;
        }
        
        int i = 0, j = 0;
        
        while(j < m){
            f2[s2.charAt(j) - 'a']++;
            
            if(j - i + 1 == n){
                if(check(f1, f2)) return true;
            }
            
            if(j - i + 1 < n) j++;
            else{
                f2[s2.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }
        return false;
    }
    
    private boolean check(int[] f1 , int[] f2){
        int[] frq = new int[26];
        
        for(int i = 0; i < 26; i++){
            if(f1[i] != f2[i]) return false;
        }
        return true;
    }
}
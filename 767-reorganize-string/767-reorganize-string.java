class Solution {
    public String reorganizeString(String s) {
        
        int[] frq = new int[26];
        int max = 0;
        char maxC = ' ';
        
        for(char c : s.toCharArray()){
            frq[c - 'a']++;
            if(frq[c-'a'] > max){
                max = frq[c-'a'];
                maxC = c;
            }
        }
        
        if(max > (s.length() + 1) / 2) return "";
        
        char[] res = new char[s.length()];
        int idx = 0;
        
        while(frq[maxC-'a'] > 0){
            res[idx] = maxC;
            frq[maxC-'a']--;
            idx += 2;
        }
        
        for(int i = 0; i < 26; i++){
            while(frq[i] > 0){
                if(idx >= s.length()){
                   idx = 1;
                }
                res[idx] = (char)(i + 'a');
                idx += 2;
                frq[i]--;
            }
        }
        return new String(res);
    }
}
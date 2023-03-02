class Solution {
    public int compress(char[] chars) {

        int idx = 0, i = 0, n = chars.length;
        StringBuilder sb = new StringBuilder();
        
        while(i < n){
            int j = i;
            while(j < n && chars[i] == chars[j]) j++;
            int cnt = j - i;
            chars[idx++] = chars[i];
            
            if(cnt <= 1) { }
            
            else if(cnt < 10){
                chars[idx++] = (char)(cnt + '0');
            }
            else{
                String s = Integer.toString(cnt);
                for(char c : s.toCharArray()){
                    chars[idx++] = c;
                }
            }
            i = j;
        }
        
        return idx;
    }
}
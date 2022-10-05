class Solution {
    public int shortestWay(String source, String target) {
        
        boolean[] vis = new boolean[26];
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        
        for(char c : source.toCharArray()){
            vis[c-'a'] = true;
        }
        
        int cnt = 0;
        
        for(int i = 0; i < target.length();){
            
            int oi = i;
            for(int j = 0; j < source.length(); j++){
                if(i < target.length() && s[j] == t[i]) i++;
            }
            if(oi == i) return -1;
            cnt++;
        }
        return cnt;
    }
}
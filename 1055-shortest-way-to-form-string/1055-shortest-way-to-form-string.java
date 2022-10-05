class Solution {
    public int shortestWay(String source, String target) {
        
        boolean[] vis = new boolean[26];
        for(char c : source.toCharArray()){
            vis[c-'a'] = true;
        }
        
        int cnt = 1;
        
        for(int i = 0, j = 0; i < target.length(); i++, j++){
            char t = target.charAt(i);
            if(vis[t -'a'] == false) return -1;
            while(j < source.length() && t != source.charAt(j)) j++;
            if(j == source.length()){
                cnt++;
                i = i-1;
                j = -1;
            }
        }
        return cnt;
    }
}
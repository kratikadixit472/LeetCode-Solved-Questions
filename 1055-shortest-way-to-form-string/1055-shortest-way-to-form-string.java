class Solution {
    public int shortestWay(String source, String target) {
        
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        
        int ans = 0;
        
        for(int i = 0; i < target.length(); ){
            int oi = i;
            for(int j = 0; j < s.length; j++){
                if(i < t.length && s[j] == t[i]) 
                    i++;
                
            }
            if(oi == i) return -1;
            ans++;
            
        }
        return ans;
    }
}

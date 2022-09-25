class Solution {
    public int shortestWay(String source, String target) {
        
        Map<Character, Boolean> map = new HashMap<>();
        
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        
        for(char c : s){
            map.put(c, true);
        }
        
        int ans = 1, j = 0;
        
        for(int i = 0; i < target.length(); i++, j++){
            if(!map.getOrDefault(t[i], false)) return -1;
            
            while(j < s.length && s[j] != t[i]){
                j++;
            }
            
            if(j == source.length()){
                j = -1;
                i -= 1;
                ans++;
            }
        }
        return ans;
    }
}
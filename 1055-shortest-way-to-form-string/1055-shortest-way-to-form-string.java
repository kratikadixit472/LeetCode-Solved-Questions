class Solution {
    public int shortestWay(String source, String target) {
        
        int[] frq = new int[26];
        int res = 1;
        for(int i = 0; i < source.length(); i++){
            frq[source.charAt(i) - 'a']++;
        }
        for(int i = 0, j = 0; i < target.length(); i++, j++){
            if(frq[target.charAt(i) - 'a'] == 0) return -1;
            
            while(j < source.length() && source.charAt(j) != target.charAt(i)) j++;
            
            if(j == source.length()){
                j = -1;
                i -= 1;
                res++;
            }
        }
        
        return res;
    }
}
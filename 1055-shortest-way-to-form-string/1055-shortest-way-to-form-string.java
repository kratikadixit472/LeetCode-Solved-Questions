class Solution {
    public int shortestWay(String source, String target) {
        
        // int[] frq = new int[26];
        int res = 0;
        // for(int i = 0; i < source.length(); i++){
        //     frq[source.charAt(i) - 'a']++;
        // }
        for(int i = 0; i < target.length();){
            int oi = i;
            for(int j = 0; j < source.length(); j++){
                if(i < target.length() && source.charAt(j) == target.charAt(i)) {
                    i++;
                }
            }
            if(i == oi) return -1;
            res++;
        }
        
        return res;
    }
}
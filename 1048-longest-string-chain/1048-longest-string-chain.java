class Solution {
    public int longestStrChain(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        
        int ans = 0;
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for(String w : words){
            map.put(w, 1);
            for(int i=0; i<w.length(); i++){
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                if(map.containsKey(next) && map.get(next)+1 > map.get(w)){
                    map.put(w, map.get(next)+1);
                }
            }
            ans = Math.max(ans, map.get(w));
        }
        return ans;
    }
}
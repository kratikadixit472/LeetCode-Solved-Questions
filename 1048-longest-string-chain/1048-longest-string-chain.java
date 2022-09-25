class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        TreeSet<String> set = new TreeSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        Collections.addAll(set, words);
        
        int ans = 0;
        
        for(String word: words){
            ans = Math.max(ans, isLongest(word, set, map));
        }
        return ans;
    }
    
    private int isLongest(String word, TreeSet<String> set, Map<String, Integer> map){
        if(map.containsKey(word)) return map.get(word);
        
        int maxLen = 1;
        StringBuilder sb = new StringBuilder(word);
        
        for(int i = 0; i < sb.length(); i++){
            sb.deleteCharAt(i);
            String newW = sb.toString();
            
            if(set.contains(newW)){
                int currLen = 1 + isLongest(newW, set, map);
                maxLen = Math.max(currLen, maxLen);
            }
            
            sb.insert(i, word.charAt(i));
        }
        map.put(word, maxLen);
        
        return maxLen;
    }
}
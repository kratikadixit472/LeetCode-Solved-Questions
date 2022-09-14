class Solution {
    public int longestStrChain(String[] words) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            set.add(w);
        }
        
        int maxLen = 0;
        for(String word : words){
            maxLen = Math.max(maxLen, getlongest(word, set, map));
        }
        
        return maxLen;
    }
    private int getlongest(String s, Set<String> words, Map<String, Integer> map){
        
        if(map.containsKey(s)) return map.get(s);
        
        int maxLen = 1;
        
        StringBuilder curr = new StringBuilder(s);
        
        for(int i = 0 ; i < curr.length(); i++){
            curr.deleteCharAt(i);
            String newString = curr.toString();
            
            if(words.contains(newString)){
                int currentLen = 1 + getlongest(newString, words, map);
                maxLen = Math.max(maxLen, currentLen);
            }
            curr.insert(i, s.charAt(i));
        }
        map.put(s, maxLen);
        return maxLen;
    }
}
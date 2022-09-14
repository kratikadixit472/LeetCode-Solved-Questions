class Solution {
    public int longestStrChain(String[] words) { 
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        
        int maxLen = 1;
        
        for(String word : words){
            
            int presentLen = 1;

            StringBuilder curr = new StringBuilder(word);

            for(int i = 0 ; i < word.length(); i++){
                curr.deleteCharAt(i);
                String predecessor = curr.toString();

                int prevLength = map.getOrDefault(predecessor, 0);
                presentLen = Math.max(presentLen, prevLength + 1);
                
                curr.insert(i, word.charAt(i));
            }
            map.put(word, presentLen);
            maxLen = Math.max(maxLen, presentLen);
        }
        
        return maxLen;
    }
}
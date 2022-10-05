class Solution {
    public int longestStrChain(String[] words) {
        
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words) set.add(word);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int longestChain = 0;
        
        for(String word : words){
            
            int maxLen = 1;
            
            StringBuilder sb = new StringBuilder(word);
            for(int i = 0; i < word.length(); i++){
                sb.deleteCharAt(i);
                String newS = sb.toString();
                if(set.contains(newS)){
                    int currLen = 1 + map.get(newS);
                    maxLen = Math.max(maxLen, currLen);
                }
                sb.insert(i, word.charAt(i));
                map.put(sb.toString(), maxLen);
            }
            
            longestChain = Math.max(longestChain, maxLen);
        }
        return longestChain;
    }
}
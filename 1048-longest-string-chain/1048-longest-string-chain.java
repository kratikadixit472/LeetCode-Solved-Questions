class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        TreeSet<String> set = new TreeSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        Collections.addAll(set, words);
        
        int longestLen = 0;
        
        for(String word: words){
            
            int presentLen = 1;
            StringBuilder sb = new StringBuilder(word);

            for(int i = 0; i < sb.length(); i++){
                sb.deleteCharAt(i);
                String predecessor = sb.toString();

                int prevLen = map.getOrDefault(predecessor, 0);
                presentLen = Math.max(presentLen, prevLen + 1);
                sb.insert(i, word.charAt(i));
            }

            longestLen = Math.max(longestLen, presentLen);
            map.put(word, presentLen);
        }
        return longestLen;
    }
}
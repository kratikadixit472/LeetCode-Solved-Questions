class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        
        List<Integer> idxAns = new ArrayList<>();
        int wordCount = words.length, wordLength = words[0].length();
        
        for(int i = 0 ; i <= s.length() - wordCount*wordLength; i++){
             Map<String, Integer> seen = new HashMap<>();
            for(int j = 0 ; j < wordCount; j++){
                
                int nextWordIndex = i + j * wordLength;
                
                String word = s.substring(nextWordIndex, nextWordIndex + wordLength);
                
                if(!map.containsKey(word)) break;
                //System.out.print(i+ " " +j+" "+word+", ");
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                
                if(seen.get(word) > map.getOrDefault(word, 0)) break;
                
                if(j + 1 == wordCount) idxAns.add(i);
            }
           // System.out.println();
        }
        return idxAns;
    }
}
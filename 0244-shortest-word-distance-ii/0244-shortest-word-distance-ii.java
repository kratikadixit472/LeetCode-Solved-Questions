class WordDistance {

    Map<String, List<Integer>> map;
    
    public WordDistance(String[] wordsDict) {
        int i = 0;
        map = new HashMap<>();
        
        for(String word : wordsDict){
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
            i++;
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);
        
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        
        while(i < w1.size() && j < w2.size()){
            minDiff = Math.min(minDiff, Math.abs(w1.get(i) - w2.get(j)));
            
            if(w1.get(i) < w2.get(j)) i++;
            else j++;
        }
        return minDiff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
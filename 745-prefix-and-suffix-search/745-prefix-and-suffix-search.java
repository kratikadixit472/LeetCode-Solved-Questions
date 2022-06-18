class WordFilter {

    HashMap<String, Integer> wordFilter;
    
    public WordFilter(String[] words) {
        
        wordFilter = new HashMap<>();
        int idx = 0;
        for(String word: words){
            ArrayList<String> plist = new ArrayList<>();
            ArrayList<String> slist = new ArrayList<>();
            for(int i=0; i<word.length(); i++){
                plist.add(word.substring(0, word.length()-i));
                slist.add(word.substring(word.length()-i));
            }
            slist.add(word);
            for(String pr : plist){
                for(String sf : slist){
                   wordFilter.put(pr + " " + sf, idx);
                }
            }
            idx++;
        }
    }
    
    public int f(String prefix, String suffix) {
    
        return wordFilter.getOrDefault(prefix+" "+suffix, -1);
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
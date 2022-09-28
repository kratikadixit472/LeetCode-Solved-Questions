class Solution {
    
    class Trie{
        
        private final Trie[] childs = new Trie[26];
        
        Trie() {};
        
        Trie(String[] dict){
            for(String word : dict){
                Trie curr = this;
                for(int i = 0; i < word.length(); i++){
                    final int index = word.charAt(i) - 'a';
                    if(curr.childs[index] == null){
                        curr.childs[index] = new Trie();
                    }
                    curr = curr.childs[index]; 
                }
            }
        }
    }
    
    private boolean oneCharDiff(Trie trie, String word, int i, boolean ifDiffAvailable){
        
        if(i == word.length()) return !ifDiffAvailable;
        
        final int index = word.charAt(i) - 'a';
        
        for(int j = 0; j < 26; j++){
            if(trie.childs[j] != null){
                if(j == index){
                    if(oneCharDiff(trie.childs[j], word, i+1, ifDiffAvailable)) return true;
                }
                else if(ifDiffAvailable){
                    if(oneCharDiff(trie.childs[j], word, i+1, !ifDiffAvailable)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean differByOne(String[] dict) {
        
        final Trie trie = new Trie(dict);
        
        int n = dict.length;
        
        for(int i = 0; i < n; i++){
            if(oneCharDiff(trie, dict[i], 0, true)) return true;
        }
        return false;
    }
}
class WordDictionary {

    class TrieNode{
        String item = "";
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }
    
    public boolean search(String word) {
        return isSame(word.toCharArray(), 0, root);
    }
    
    private boolean isSame(char[] w, int k, TrieNode node){
        if(k == w.length) return !node.item.equals("");
        
        if(w[k] != '.'){
            return node.children[w[k] - 'a'] != null && isSame(w, k + 1, node.children[w[k] - 'a']);
        }
        else{
            for(int i = 0 ; i < 26; i++){
                if(node.children[i] != null){
                    if(isSame(w, k + 1, node.children[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
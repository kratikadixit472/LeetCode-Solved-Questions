class Trie {
    
    class TrieN{
        TrieN[] child;
        String isWord;
        
        TrieN(){
            child = new TrieN[26];
            isWord = "";
        }
    }
    TrieN root;
    
    public Trie() {
        root = new TrieN();
    }
    
    public void insert(String word) {
        TrieN node = root;
        for(char c : word.toCharArray()){
            if(node.child[c - 'a'] == null) node.child[c - 'a'] = new TrieN();
            node = node.child[c-'a'];
        }
        node.isWord = word;
    }
    
    public boolean search(String word) {
        TrieN node = root;
        for(char c : word.toCharArray()){
            if(node.child[c - 'a'] != null) node = node.child[c-'a'];
            else return false; 
        }
        return word.equals(node.isWord);
    }
    
    public boolean startsWith(String prefix) {
        TrieN node = root;
        for(char c : prefix.toCharArray()){
            if(node.child[c - 'a'] != null) node = node.child[c-'a'];
            else return false; 
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
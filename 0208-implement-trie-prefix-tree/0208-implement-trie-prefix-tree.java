class Trie {

    class TrieNode{
        String item = "";
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public Trie() {
       root = new TrieNode(); 
    }
    
    public void insert(String word) {
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
    
    public boolean startsWith(String prefix) {
        return isPrefix(prefix.toCharArray(), 0, root);
    }
    
    private boolean isSame(char[] w, int k, TrieNode node){
        if(k == w.length) return !node.item.equals("");
        return node.children[w[k] - 'a'] != null && isSame(w, k + 1, node.children[w[k] - 'a']);
    }
    
    private boolean isPrefix(char[] w, int k, TrieNode node){
        if(k == w.length) return true;
        return node.children[w[k] - 'a'] != null && isPrefix(w, k + 1, node.children[w[k] - 'a']);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
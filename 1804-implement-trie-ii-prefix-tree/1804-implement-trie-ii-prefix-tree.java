class Trie {

   class TrieNode{
        
        TrieNode[] children;
        int count = 0, end = 0;
       
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
            node.count = node.count + 1;
        }
        node.end = node.end + 1;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.end;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        
        for(char c : prefix.toCharArray()){
            if(node.children[c - 'a'] == null){
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.count;
    }
    
    public void erase(String word) {
        TrieNode node = root;
        
        for(char c : word.toCharArray()){
            
            node = node.children[c - 'a'];
            node.count = node.count - 1;
        }
        node.end = node.end - 1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
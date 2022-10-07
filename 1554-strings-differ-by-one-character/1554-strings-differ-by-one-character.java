class Solution {
    
    class Trie{
        
        HashMap<Character, Trie> children;
        
        boolean end;
        
        public Trie(){
            children = new HashMap<>();
        }
    }
    
    public boolean differByOne(String[] dict) {
        
        Trie root = buildTrie(dict);
        
        for(String s : dict){
            if(search(s, root, 0, 0)) return true;
        }
        return false;
    }
    
    private boolean search(String s, Trie root, int idx, int diff){
        
        if(diff > 1) return false;
        
        if(idx >= s.length()){
            if(diff == 1 && root.end) return true;
            return false;
        }
        
        char c = s.charAt(idx);
        
        for(char key : root.children.keySet()){
            
            if(key == c){
                if(search(s, root.children.get(key), idx+1, diff)) return true;
            }
            else{
                if(search(s, root.children.get(key), idx+1, diff+1)) return true;
            }
            
        }
        return false;
    }
    
    private Trie buildTrie(String[] dict){
        
        Trie root = new Trie();
        
        for(String s : dict){
            Trie node = root;
            for(char c : s.toCharArray()){
                if(!node.children.containsKey(c)){
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.end = true;
        }
        return root;
    }
}
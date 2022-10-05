class Solution {
    
    class Node{
        int idx;
        String word;
        
        public Node(String s, int idx){
            this.word = s;
            this.idx = idx;
        }
    }
    
    public int numMatchingSubseq(String s, String[] words) {
        
        List<Node>[] head = new ArrayList[26];
        
        for(int i = 0; i < 26; i++){
            head[i] = new ArrayList<Node>();
        }
        
        for(String word : words){
            head[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            List<Node> old = head[c-'a'];
            head[c-'a'] = new ArrayList();
            
            for(Node node : old){
                node.idx++;
                if(node.idx == node.word.length()){
                    ans++;
                }
                else{
                    head[node.word.charAt(node.idx) - 'a'].add(node);
                }
            }
            old.clear();
        }
        return ans;
    }
}
class Solution {
    
    class Node{
        
        int idx;
        String s;
        public Node(String s, int idx){
            this.s = s;
            this.idx = idx;
        }
    }
    
    public int numMatchingSubseq(String s, String[] words) {
        
        int cnt = 0;
        List<Node>[] head = new ArrayList[26];
        
        for(int i = 0; i < 26; i++){
            head[i] = new ArrayList<Node>();
        }
        
        for(String word : words){
            head[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        
        for(char c : s.toCharArray()){
            List<Node> old = head[c-'a'];
            head[c-'a'] = new ArrayList<>();
            
            for(Node node : old){
                node.idx++;
                if(node.idx == node.s.length()){
                    cnt++;
                }
                else{
                    head[node.s.charAt(node.idx) - 'a'].add(node);
                }
            }
            old.clear();
        }
        
        return cnt;
    }
}
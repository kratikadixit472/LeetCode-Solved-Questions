class Solution {
    
    Map<String, String> par;
    
    private String findPar(String u){
        if(!par.containsKey(u)) return u;
        
         if(par.get(u) == u) return u ;
         par.put(u, findPar(par.get(u)));
        return par.get(u);
    }
    
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if(sentence1.length != sentence2.length) return false;
        
        par = new HashMap<>();
        
        for(List<String> s : similarPairs){
            String word1 = s.get(0);
            String word2 = s.get(1);
            
            if(!par.containsKey(word1))
                par.put(word1,word1);
            if(!par.containsKey(word2))
                par.put(word2,word2);
        }
        
        for(List<String> s : similarPairs){
            String p1 = findPar(s.get(0));
            String p2 = findPar(s.get(1));
            
            if(p1 != p2){
                par.put(par.get(p2), par.get(p1));
            }
        }
        
        for(int i = 0;  i< sentence1.length; i++){
            String p1 = findPar(sentence1[i]);
            String p2 = findPar(sentence2[i]);
            
            // if(sentence1[i] != sentence2[i] && p1 == null && p2 == null) return false; 
            if(!p1.equals(p2)) return false;
        }
        return true;
    }
}
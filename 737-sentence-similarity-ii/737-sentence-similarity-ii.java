class Solution {
    
    Map<String, String> map;
    
    private String findPar(String s){
        if(!map.containsKey(s)) return s;
        
        if(map.get(s) == s) return s;
        
        map.put(s, findPar(map.get(s)));
        return map.get(s);
    }
    
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if(sentence1.length != sentence2.length) return false;
        
        map = new HashMap<>();
        for(List<String> s : similarPairs){
            if(!map.containsKey(s.get(0))) map.put(s.get(0), s.get(0));
            if(!map.containsKey(s.get(1))) map.put(s.get(1), s.get(1));
        }
        
        for(List<String> s : similarPairs){
            String s1 = s.get(0), s2 = s.get(1);
            String p1 = findPar(s1), p2 = findPar(s2);
            
            if(p1 != p2){
                map.put(map.get(p1), map.get(p2));
            }
        }
        
        for(int i = 0 ; i < sentence1.length; i++){
            String s1 = sentence1[i], s2 = sentence2[i];
            String p1 = findPar(s1), p2 = findPar(s2);
            // if(s1.equals(s2)) continue;
            
            if(!p1.equals(p2)){
                return false;
            }
        }
        
        return true;
    }
}
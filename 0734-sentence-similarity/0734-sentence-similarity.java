class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if(sentence1.length != sentence2.length) return false;
        
        Map<String, Set<String>> map = new HashMap<>();
        
        for(List<String> p: similarPairs){
            map.putIfAbsent(p.get(0), new HashSet<>());
            map.get(p.get(0)).add(p.get(1));
            
            map.putIfAbsent(p.get(1), new HashSet<>());
            map.get(p.get(1)).add(p.get(0));
        }
        
        for(int i = 0; i < sentence1.length; i++){
            
            if(sentence1[i].equals(sentence2[i])) continue;
            
            if(map.containsKey(sentence1[i]) && map.get(sentence1[i]).contains(sentence2[i])) continue;
            
            return false;
        }
        return true;
    }
}
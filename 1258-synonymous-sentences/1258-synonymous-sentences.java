class Solution {
    
    private void connect(String a, String b, Map<String, List<String>> map){
        map.putIfAbsent(a, new ArrayList<>());
        map.get(a).add(b);
    }
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new TreeSet<>();
        
        for(List<String> s : synonyms){
            String w1 = s.get(0), w2 = s.get(1);
            connect(w1, w2, map);
            connect(w2, w1, map);
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(text);
        
        while(!q.isEmpty()){
            
            String top = q.poll();
            set.add(top);
            
            String[] words = top.split("\\s");
            for(int i = 0; i < words.length; i++){
                
                if(map.get(words[i]) == null) continue;
                
                for(String al : map.get(words[i])){
                    words[i] = al;
                    String newS = String.join(" ", words);
                    if(!set.contains(newS)) q.add(newS);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
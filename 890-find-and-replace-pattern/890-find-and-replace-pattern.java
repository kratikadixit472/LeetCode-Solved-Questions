class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(isMatch(word, pattern)){
                ans.add(word);
            }
        }
        return ans;
    }
    
    private boolean isMatch(String word, String pattern){
        
        if(word.length() == 1 && pattern.length() == 1) return true;
           
        if(word.length() != pattern.length()) return false;
        
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        
        for(int i = 0; i < word.length(); i++){
            Character w = word.charAt(i);
            Character p = pattern.charAt(i);
            
            if(!m1.containsKey(w)) m1.put(w, p);
            if(!m2.containsKey(p)) m2.put(p, w);
            
            if(m1.get(w) != p || m2.get(p) != w) return false;
        }
        
        return true;
    }
}
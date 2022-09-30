class Solution {
    public String longestWord(String[] words) {
        
        Arrays.sort(words);
        
        Set<String> set = new HashSet<>();
        
        String res = "";
        
        for(String w : words){ 
            if(w.length() == 1 || set.contains(w.substring(0, w.length()-1))){
                res = (w.length() > res.length() ? w : res);
                set.add(w);
            }
        }
        return res;
    }
}
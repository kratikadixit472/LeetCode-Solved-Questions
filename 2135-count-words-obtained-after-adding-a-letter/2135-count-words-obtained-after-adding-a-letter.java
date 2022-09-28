class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        Map<Integer, Set<String>> map = new HashMap<>();
        
        for(String w : startWords){
            char[] ch = getHash(w);
            map.putIfAbsent(w.length(), new HashSet<>());
            map.get(w.length()).add(String.valueOf(ch));
        }
        
        int res = 0;
        
        for(String w : targetWords){
            int sz = w.length()-1;
            if(map.containsKey(sz)){
                char[] ch = getHash(w);
                for(char c : w.toCharArray()){
                    --ch[c - 'a'];
                    if(map.get(sz).contains(String.valueOf(ch))){
                        res++;
                        break;
                    }
                    ++ch[c - 'a'];
                }
            }
        }
        return res;
    }
    private char[] getHash(String w){
        char[] ch = new char[26];
        for(char c : w.toCharArray()){
            ch[c - 'a']++;
        }
        return ch;
    }
}

/*["g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"]
["r","am","jg","umhjo","fov","lujy","b","uz","y"]*/
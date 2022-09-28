class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        Set<Integer> set = new HashSet<>();
        
        for(String w : startWords){
            int val = getHash(w);
            set.add(val);
        }
        
        int res = 0;
        
        for(String w : targetWords){
            int num = getHash(w);
            for(int i = 0; i < 26; i++){
                if((num & (1 << (i))) > 0){
                    int tmp = num - (1 << (i));
                    if(set.contains(tmp)){
                        res++;
                        break;
                    }
                }
            }
            
        }
        return res;
    }
    private int getHash(String w){
        // char[] ch = new char[26];
        int res = 0;
        
        for(char c : w.toCharArray()){
            // ch[c - 'a']++;
            res = res + (1 << (c - 'a'));
        }
        return res;
    }
}

/*["g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"]
["r","am","jg","umhjo","fov","lujy","b","uz","y"]*/
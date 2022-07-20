class Solution {
    
    char[] ca;
    public int numMatchingSubseq(String s, String[] words) {
        
        int ans = 0;
        
        List<StringBuilder>[] waiting = new List[129];
        
        for(int i = 0; i < 26; i++){
            waiting[i] = new ArrayList<StringBuilder>();
        }
        
        for(String word : words){
            waiting[word.charAt(0) - 'a'].add(new StringBuilder(word));
        }
        
        for(char c : s.toCharArray()){
            
            List<StringBuilder> advanced = waiting[c-'a'];
            
            waiting[c - 'a'] = new ArrayList<>();
            
            for(StringBuilder sb : advanced){
                sb.deleteCharAt(0);
                if(sb.length() != 0){
                    waiting[sb.charAt(0)-'a'].add(sb);
                }
                else ans++;
            }
        }
        return ans;
    }
}
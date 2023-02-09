class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String>[] set = new HashSet[26];
        for(int i = 0; i < 26; i++){
            set[i] = new HashSet<>();
        }
        
        for(String s : ideas){
            set[s.charAt(0)-'a'].add(s.substring(1));
        }
        
        int n = ideas.length;
        long ans = 0;
        
        for(int i = 0; i < 26; i++){
            for(int j = i+1; j < 26; j++){
                
                long c1 = 0, c2 = 0;
                for(String s : set[i]){
                    if(!set[j].contains(s)) c1++;
                }
                
                for(String s : set[j]){
                    if(!set[i].contains(s)) c2++;
                }
                ans += c1 * c2;
            }
        }
        return 2*ans;
    }
}
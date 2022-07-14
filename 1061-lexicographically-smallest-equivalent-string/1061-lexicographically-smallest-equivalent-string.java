class Solution {
    
    int[] par;
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        par = new int[26];
        
        for(int i = 0; i < 26; i++) par[i] = i;
        
        for(int i = 0; i < s1.length(); i++){
            
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            
            int p1 = findPar(ch1 - 'a');
            int p2 = findPar(ch2 -  'a');
            
            if(p1 != p2){
                par[p1] = Math.min(par[p1], par[p2]);
                par[p2] = Math.min(par[p1], par[p2]);
            }
        }
        
        String ans = "";
        
        for(char ch : baseStr.toCharArray()){
            int p = findPar(ch - 'a');
            ans += (char)(p + 'a');
        }
        return ans;
    }
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
}
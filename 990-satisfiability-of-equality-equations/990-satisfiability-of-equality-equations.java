class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public boolean equationsPossible(String[] equations) {
        
        par = new int[26];
        
        for(int i = 0; i < 26; i++) par[i] = i;
        
        for(String s : equations){
            char u = s.charAt(0), v = s.charAt(3), sign = s.charAt(1);
            int p1 = findPar(u - 'a'), p2 = findPar(v - 'a');
            
            if(p1 != p2 && sign == '='){
                par[p2] = p1;
            }
        }
        for(String s : equations){
            char u = s.charAt(0), v = s.charAt(3), sign = s.charAt(1);
            int p1 = findPar(u - 'a'), p2 = findPar(v - 'a');
            
            if(p1 == p2 && sign == '!'){
                return false;
            }
        }
        return true;
    }
}
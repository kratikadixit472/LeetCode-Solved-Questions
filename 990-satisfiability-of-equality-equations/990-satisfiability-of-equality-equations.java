class Solution {
    
    int[] par;
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public boolean equationsPossible(String[] equations) {
        
        par = new int[26];
        
        for(int i = 0; i <26; i++){
            par[i] = i;
        }
        
        for(String s : equations){
            char sign = s.charAt(1);
            int a = s.charAt(0) - 'a', b = s.charAt(3) - 'a';
            if(sign == '='){
                union(a, b);
            }
        }
        
        for(String s : equations){
            char sign = s.charAt(1);
            int a = s.charAt(0)-'a', b = s.charAt(3)-'a';
            if(sign == '!'){
                int p1 = findPar(a), p2 = findPar(b);
                if(p1 == p2) return false;
            }
        }
        
        return true;
    }
    private void union(int i, int j){
        
        int p1 = findPar(i), p2 = findPar(j);
        
        if(p1 != p2){
            par[p1] = par[p2];
        }
    }
}
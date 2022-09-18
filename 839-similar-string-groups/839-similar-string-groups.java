class Solution {
    
    int[] par, w;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    private boolean isUnion(int i, int j){
        int p1 = findPar(i), p2 = findPar(j);
        if(p1 == p2) return false;
        
        if(w[p1] < w[p2]) {
            w[p2] += w[p1];
            par[p1] = p2;
        }
        else {
            w[p1] += w[p2];
            par[p2] = p1;
        }
        return true;
    }
    
    private boolean isSimilar(String a, String b){
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
            if(cnt > 2) return false;
            
        }
        return true;
    }
    
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        
        par = new int[n];
        w = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
            w[i] = 1;
        }
        
        int size = n;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j <n; j++){
                if(isSimilar(strs[i], strs[j]) && isUnion(i, j)){
                    size--;
                }
            }
        }
        return size;
    }
    
}
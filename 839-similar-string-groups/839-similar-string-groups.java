class Solution {
    
    int[] par;
    
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        par = new int[n];
        
        for(int i = 0 ; i < strs.length; i++){
            par[i] = i;
        }
        
        int ans = n;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                
                if(isSimilar(strs[i], strs[j])){
                    
                    int p1 = findPar(i);
                    int p2 = findPar(j);
                    
                    if(p1 != p2){
                        par[p2] = p1;
                        ans--;
                    }
                }
                
            }
        }
        return ans;
    }
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    private boolean isSimilar(String s1, String s2){
        
        int cnt = 0;
        
        for(int i =0 ; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
            
            if(cnt > 2) return false;
        }
        return true;
    }
}
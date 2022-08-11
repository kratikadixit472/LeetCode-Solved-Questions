class Solution {
    
    int[] size, par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int largestComponentSize(int[] nums) {
        
        int n = 0;
        for(int ele : nums) n = Math.max(n, ele);
        
        size = new int[n + 1];
        par = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            par[i] = i;
            size[i] = 1;
        }
        
        for(int ele : nums){
            for(int fact = 2; fact <= (int)Math.sqrt(ele); fact++){
                
                if(ele % fact == 0){
                    union(ele, fact);
                    union(ele, ele / fact);
                }
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int ans = 0;
        
        for(int ele : nums){
            int par = findPar(ele);
            int cnt = map.getOrDefault(par, 0);
            map.put(par, cnt + 1);
            ans = Math.max(ans, cnt + 1);
        }
        
        return ans;
    }
    
    private void union(int x, int y){
        
        int xp = findPar(x), yp = findPar(y);
        
        if(xp != yp){
            
            if(size[xp] > size[yp]){
                int tmp = xp;
                xp = yp;
                yp = tmp;
            }
            
            par[xp] = yp;
            size[yp] += size[xp];
        }
    }
}
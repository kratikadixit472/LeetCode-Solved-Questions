class Solution {
    
    int[] par, size;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public int countServers(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{1, 0}, {0,1}, {-1, 0}, {0, -1}};
        
        List<int[]> al = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    al.add(new int[]{i, j});
                }
            }
        }
        
        par = new int[al.size()]; size = new int[al.size()];
        
        for(int i = 0; i < al.size() ; i++){
            par[i] = i;
            size[i] = 1;
        }
        
        
        for(int i = 0; i < al.size(); i++){
            for(int j = i+1; j < al.size(); j++){
                if(al.get(i)[0] == al.get(j)[0] || al.get(i)[1] == al.get(j)[1]){
                    
                    int p1 = findPar(i );
                    
                            int p2 = findPar(j);
                            if(p1 != p2){
                                par[p2] = p1;
                                size[p1] += size[p2];
                            }
                
                }
            }
            
        }
        
        int ans = 0;
        
        for(int i = 0; i < al.size(); i++){
            if(par[i] == i && size[i] > 1) {
                ans += size[i];
            }
        }
        
        return ans;
    }
}
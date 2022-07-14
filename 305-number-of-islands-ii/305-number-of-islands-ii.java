class Solution {
    
   int[] par;
    
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        
        int[][] grid = new int[n][m];
        par = new int[n*m];
        
        for(int i = 0 ; i < n * m ; i++) par[i] = i;
        
        int cnt = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for(int[] pos : positions){
            
            int i = pos[0], j = pos[1];
            
            if(grid[i][j] == 1){
                ans.add(cnt); continue;
            }
            
            int p1 = findPar(i * m + j);
            
            grid[i][j] = 1;
            cnt++;
            
            for(int d[] : dir){
                
                int r = d[0] + i;
                int c = d[1] + j;
                
                if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                    int p2 = findPar(r * m + c);
                    if(p1 != p2) {
                        cnt--;
                        par[p2] = p1;
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
}
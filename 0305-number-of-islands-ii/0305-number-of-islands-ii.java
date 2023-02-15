class Solution {
    int[] par;
        
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        
        par = new int[m*n];
        int[][] grid = new int[n][m];
        
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
        for(int i = 0; i < m*n; i++){
            par[i] = i;
        }
        int cnt = 0;
        
        for(int[] pos : positions){
            
            int i = pos[0], j = pos[1];
            
            if(grid[i][j] == 1){
                ans.add(cnt);
                continue;
            }
            
            grid[i][j] = 1;
            cnt++;
            
            int p1 = findPar(i * m + j);
            
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                
                if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                    int p2 = findPar(r * m + c);
                    if(p1 != p2){
                        cnt--;
                        par[p2] = p1;
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
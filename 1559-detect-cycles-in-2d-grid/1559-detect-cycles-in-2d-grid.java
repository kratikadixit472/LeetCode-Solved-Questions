class Solution {
    
    public boolean containsCycle(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        boolean hasCycle = false;
        
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{1,0}, {0,1}, {0,-1}, {-1,0}};
        
        for(int i =0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j]){
                    hasCycle = hasCycle || DFS(-1, -1, i, j, n, m, grid, vis, dir);
                }
            }
        }
        return hasCycle;
    }
    private boolean DFS(int lr, int lc, int i, int j, int n, int m, char[][] grid, boolean[][] vis, int[][] dir){
        
        vis[i][j] = true;
        
        boolean result = false;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == grid[i][j]){
                if(r == lr && c == lc){
                    continue;
                }
                if(vis[r][c]) {
                    result = true;
                }
                vis[r][c] = true;
                result = result || DFS(i, j, r, c, n, m, grid, vis, dir);
            }
        }
        return result;
    }
}
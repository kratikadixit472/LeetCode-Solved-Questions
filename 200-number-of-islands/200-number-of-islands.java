class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        int island = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    DFS(i, j, n, m, grid, dir);
                    island++;
                }
            }
        }
        
        return island;
    }
    
    private void DFS(int sr, int sc, int er, int ec, char[][] grid, int[][] dir){
        
        grid[sr][sc] = '0';
        
        for(int[] d : dir){
            
            int r = sr + d[0];
            int c = sc + d[1];
            
            if(r >= 0 && c >= 0 && r<er && c<ec && grid[r][c] == '1'){
                DFS(r, c, er, ec, grid, dir);
            }
        }
    }
}
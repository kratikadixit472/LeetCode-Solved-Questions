class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        int maxIsland = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int count = DFS(i, j, n, m, grid, dir);
                    maxIsland = Math.max(maxIsland, count);
                }
            }
        }
        
        return maxIsland;
    }
    
    private int DFS(int sr, int sc, int er, int ec, int[][] grid, int[][] dir){
        
        grid[sr][sc] = 0;
        
        int count = 0;
        
        for(int[] d : dir){
            
            int r = sr + d[0];
            int c = sc + d[1];
            
            if(r >= 0 && c >= 0 && r<er && c<ec && grid[r][c] == 1){
                count += DFS(r, c, er, ec, grid, dir);
            }
        }
        return count + 1;
    }
}
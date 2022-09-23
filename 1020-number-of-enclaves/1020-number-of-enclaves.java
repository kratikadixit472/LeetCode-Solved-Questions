class Solution {
    
    int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && (i == 0 || j == 0 || i == n-1 || j == m-1)){
                    DFS(i, j, n, m, grid);
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count += DFS(i, j, n, m, grid);
                    // System.out.println(count);
                }
            }
        }
        return count;
    }
    
    private int DFS(int i, int j, int n, int m, int[][] grid){
        grid[i][j] = 0;
        
        int count = 1;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                count += DFS(r, c, n, m, grid);
            }
        }
        return count;
    }
}
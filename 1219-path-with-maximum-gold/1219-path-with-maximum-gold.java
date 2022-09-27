class Solution {
    
    int n, m;
    
    public int getMaximumGold(int[][] grid) {
        
        n = grid.length; m = grid[0].length;
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;
                max = Math.max(max, findMaxGold(i, j, grid));
            }
        }
        return max;
    }
    
    int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    private int findMaxGold(int i, int j, int[][] grid){
        
        int original = grid[i][j];
        grid[i][j] = 0;
        
        int max = 0;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] != 0){
                max = Math.max(max, findMaxGold(r, c, grid));
            }
        }
        grid[i][j] = original;
        return max + original;
    }
}
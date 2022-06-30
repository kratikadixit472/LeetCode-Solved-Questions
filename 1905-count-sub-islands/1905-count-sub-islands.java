class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
      int n = grid2.length;
        int m = grid2[0].length;
        
        int count = 0;
        
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid2[i][j] == 1){
                    if(dfs(i, j, n, m, grid2, dir, grid1)) {
                        System.out.println(i + " "+ j+", ");
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    public boolean dfs(int i, int j,int n, int m, int[][] grid2, int[][] dir, int[][] grid1)
    {
        
        if(grid2[i][j] != grid1[i][j]) return false;
        
        grid2[i][j] = 0;
        boolean result = true;
        
        for(int d=0; d<4; d++){
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            
            if(x >= 0 && y >= 0 && x < grid2.length && y < grid2[0].length && grid2[x][y] == 1){
                
                 if(!dfs(x, y, n, m, grid2, dir, grid1)) {
                     result = false;
                 }
            }
        }
        
        return result;
    }
}
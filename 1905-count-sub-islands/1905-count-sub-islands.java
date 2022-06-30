class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
      int n = grid2.length;
        int m = grid2[0].length;
        
        int count = 0;
        
        //int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid2[i][j] == 1){
                    if(dfs(i, j, n, m, grid2, grid1)) {
                       // System.out.println(i + " "+ j+", ");
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    public boolean dfs(int i, int j, int n, int m, int[][] grid2, int[][] grid1)
    {
       
        boolean result = true;
        
        if(i >= 0 && j >= 0 && i < n && j < m && grid2[i][j] == 1){
            
        if(grid2[i][j] != grid1[i][j]) return false;
        
            grid2[i][j] = 0;
            boolean up = dfs(i-1, j, n, m, grid2, grid1);
            boolean left = dfs(i, j-1, n, m, grid2, grid1);
            boolean down = dfs(i+1, j, n, m, grid2, grid1);
            boolean right = dfs(i, j+1, n, m, grid2, grid1);
            
            if(!up || !left || !down || !right) return false;
        }
        
        return result;
    }
}
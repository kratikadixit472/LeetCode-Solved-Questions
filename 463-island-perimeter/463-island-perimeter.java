class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int one = 0, ngbr = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 1){
                    one++;
                    
                    if(i-1 >= 0 && grid[i-1][j] == 1) ngbr++;
                    
                    if(j-1 >= 0 && grid[i][j-1] == 1) ngbr++;
                }
            }
        }
        return one * 4 - 2 * ngbr;
    }
}
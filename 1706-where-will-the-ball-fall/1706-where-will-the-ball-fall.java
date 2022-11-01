class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid[0].length;
        int[] res = new int[m];
        
        for(int i = 0; i < m; i++){
            res[i] = findBallDropCol(0, i, grid);
        }
        return res;
    }
    
    private int findBallDropCol(int row, int col, int[][] grid){
        
        if(row == grid.length) return col;
        
        int nextCol = col + grid[row][col];
        
        if(nextCol < 0 || nextCol >= grid[0].length || grid[row][nextCol] != grid[row][col]) {
            return -1;
        }
        
        return findBallDropCol(row + 1, nextCol, grid);
    }
}
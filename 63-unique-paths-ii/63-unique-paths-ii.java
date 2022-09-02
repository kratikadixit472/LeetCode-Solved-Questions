class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;
        
        return findAllPossible(0, 0, n-1, m-1, new int[n][m], obstacleGrid);
    }
    
    private int findAllPossible(int sr, int sc, int er, int ec, int[][] dp, int[][] obstacleGrid){
        
        if(sr == er && sc == ec) return 1;
        
        if(obstacleGrid[sr][sc] == 1) return 0;
        
        if(dp[sr][sc] != 0) return dp[sr][sc];
        
        int count = 0;
        
        if(sr + 1 <= er){
            count += findAllPossible(sr + 1, sc, er, ec, dp, obstacleGrid);
        }
        if(sc + 1 <= ec){
            count += findAllPossible(sr, sc + 1, er, ec, dp, obstacleGrid);
        }
        dp[sr][sc] = count;
        
        return dp[sr][sc];
    }
}
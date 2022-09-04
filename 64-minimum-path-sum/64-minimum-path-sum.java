class Solution {
    public int minPathSum(int[][] grid) {
        
        return getMinPath(grid.length, grid[0].length, grid);
    }
    
    private int getMinPath(int er, int ec, int[][] grid){
        
        int[][] dp = new int[er][ec];
        
        for(int[] arr : dp){
            Arrays.fill(arr, (int)(1e8));
        }
        
        for(int sr = er-1; sr >= 0 ; sr--){
            for(int sc = ec-1; sc >= 0; sc--){
                
                if(sr == er-1 && sc == ec-1) {
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                } 
                
                if(sr + 1 < er){
                    dp[sr][sc] = Math.min(dp[sr][sc], dp[sr + 1][sc]);
                }
                if(sc + 1 < ec){
                    dp[sr][sc] = Math.min(dp[sr][sc], dp[sr][sc + 1]);
                }
                dp[sr][sc] += grid[sr][sc];
            }
        }
        
        return dp[0][0];
    }
}
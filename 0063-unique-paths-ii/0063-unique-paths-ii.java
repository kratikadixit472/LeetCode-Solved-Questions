class Solution {
    
    public int uniquePathsWithObstacles(int[][] grid) {
        
        int i = 0, j = 0, n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return 0;
        
        int[][] dir = {{1, 0}, {0, 1}};
        
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return numberPath(0, 0, n, m, grid, dir, dp);
    }
    
    private int numberPath(int sr, int sc, int n, int m, int[][] grid, int[][] dir, int[][] dp){
        
        if(sr == n-1 && sc == m-1 && grid[sr][sc] == 0){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc] != -1) return dp[sr][sc];
        int cnt = 0;
        
        for(int[] d : dir){
            int r = d[0] + sr;
            int c = d[1] + sc;

            if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 1)continue;
            cnt += numberPath(r, c, n, m, grid, dir, dp);
        }
        dp[sr][sc] = cnt;
        return cnt;
    }
}
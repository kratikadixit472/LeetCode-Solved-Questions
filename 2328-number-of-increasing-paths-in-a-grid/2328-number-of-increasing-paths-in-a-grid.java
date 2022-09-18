class Solution {
    
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int mod = (int)(1e9 + 7);
    int n, m;
    
    public int countPaths(int[][] grid) {
        
        n = grid.length; m = grid[0].length;
        int ans = 0;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = (ans % mod + DFS(i, j, grid, dp) % mod) % mod;
            }
        }
        
        return ans;
    }
    private int DFS(int i, int j, int[][] matrix, int[][] dp){
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int ans = 1;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && matrix[i][j] < matrix[r][c]){
                ans = (ans % mod + DFS(r, c, matrix, dp) % mod) % mod; 
            }
        }
        return dp[i][j] = ans;
    }
}
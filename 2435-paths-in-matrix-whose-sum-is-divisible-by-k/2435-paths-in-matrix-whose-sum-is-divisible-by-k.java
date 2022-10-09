class Solution {
    
    int[][] dir = {{0, 1}, {1, 0}};
    String[] dirs = {"r", "d"};
    int n, m;
    int mod = (int)(1e9 + 7);
    
    public int numberOfPaths(int[][] grid, int k) {
        n = grid.length; m = grid[0].length;
        
        return DFS(0, 0, grid, 0, k, new Integer[n][m][k]) % mod;
    }
    
    private int DFS(int r, int c, int[][] grid, int curr, int k , Integer[][][] dp){
        
        if(r == n-1 && c == m-1){
            if((grid[r][c] + curr) % k == 0){
                // System.out.println(sum+" "+ s);
                return dp[r][c][curr] = 1;
            }
            return 0;
        }
        if(r >= n || c >= m) return 0;
        
        if(dp[r][c][curr] != null) return dp[r][c][curr];
        
        int ans = 0;
        
        for(int i = 0; i < 2; i++){
            int[] d = dir[i];
            int nr = r + d[0];
            int nc = c + d[1];
            
            if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                ans = (ans + DFS(nr, nc, grid, (curr + grid[r][c]) % k, k, dp)) % mod;
            }
        }
        return dp[r][c][curr] = ans;
    }
}
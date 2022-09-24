class Solution {
    
    int[][] dir = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    int mod = (int)(1e9 + 7);

    public int knightDialer(int n) {
        
        int ans = 0;
        
        Integer[][][] dp = new Integer[4][3][n+1];
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                // if(i == 3 && (j == 0 || j == 2)) continue;
                ans = (ans + DFS(i, j, n, dp)) % mod;
            }
           
        }
        return ans;
    }
    
    private int DFS(int i, int j, int n, Integer[][][] dp){
        
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;
        
        if(n == 1) return 1;
        
        if(dp[i][j][n] != null) return dp[i][j][n];
        
        int cnt = 0;
        
        for(int[] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
           
            cnt = (cnt + DFS(nr, nc, n-1, dp)) % mod;
        
        }
        return dp[i][j][n] = cnt;
    }
}
class Solution {
    public double knightProbability(int n, int K, int row, int column) {
        
        int[][] dir = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        
        double[][][] dp = new double[K+1][n][n];
        dp[0][row][column] = 1;
        
        for(int k = 1; k <= K; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int[] d : dir){
                        int r = i - d[0];
                        int c = j - d[1];
                        if(r >= 0 && c >= 0 && r < n && c < n){
                            dp[k][i][j] += (dp[k-1][r][c]) / 8.0;
                        }
                    }
                }
            }
        }
        
        double ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans += dp[K][i][j];
            }
        }
        return ans;
    }
}
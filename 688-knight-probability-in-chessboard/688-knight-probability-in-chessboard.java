class Solution {
    public double knightProbability(int n, int K, int row, int column) {
        
        double ways = 0;
        int[][] dir = {{2,1}, {2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};
        double[][][] dp = new double[K+1][n][n];
        
        dp[0][row][column] = 1;
        
        for(int k = 1; k <= K; k++){
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    double count = 0;
                    for(int[] d : dir){
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                            dp[k][r][c] += (dp[k-1][nr][nc]) / 8.0;
                        }
                    }
                    // dp[k][r][c] = count / 8.0;
                }
            }
        }
        double ans = 0;
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n ; c++){
                ans += dp[K][r][c];
            }
        }
        return ans;
    }
}
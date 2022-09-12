class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        double ways = 0;
        int[][] dir = {{2,1}, {2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};
        double[][][] dp = new double[k+1][n+1][n+1];
        
        return  getAllPossible(n, row, column, k, dir, dp);
        
    }
    
    private double getAllPossible(int n, int i, int j, int k, int[][] dir, double[][][] dp){
        
        if(k == 0) return dp[k][i][j] = 1.0;
        
        if(dp[k][i][j] != 0.0) return dp[k][i][j];
        
        double count = 0;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < n){
                count += getAllPossible(n, r, c, k-1, dir, dp);
            }
        }
        return dp[k][i][j] = count / 8.0;
    }
}
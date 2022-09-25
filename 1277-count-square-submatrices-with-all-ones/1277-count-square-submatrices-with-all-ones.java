class Solution {
    int n, m;
    public int countSquares(int[][] matrix) {
        n = matrix.length; m = matrix[0].length;
        int count = 0;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(matrix[i][j] == 1){
                    if(i > 0 && j > 0){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }
                count += dp[i][j];
            }   
        }
        return count;
    }
}
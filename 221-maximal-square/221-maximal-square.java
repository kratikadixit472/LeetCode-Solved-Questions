class Solution {
    int[][] dp;
    public int maximalSquare(char[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        int res = 0;
        dp = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == '1'){
                    dp[i][j] = (findSquare(i, j, mat, n, m));
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(dp[i][j] +" ");
            }System.out.println();
        }
        return res*res;
    }
    
    private int findSquare(int r, int c, char[][] mat, int n, int m){
        
        if(r < 0 || c < 0 || r >= n || c  >= m || mat[r][c] == '0'){
            return 0;
        }
        
        if(dp[r][c] != 0) return dp[r][c];
        
        dp[r][c] = 1 + Math.min(findSquare(r+1, c+1, mat, n, m), Math.min(findSquare(r+1, c, mat, n, m), findSquare(r, c+1, mat, n, m)));
        
        return dp[r][c];
        
    } 
}
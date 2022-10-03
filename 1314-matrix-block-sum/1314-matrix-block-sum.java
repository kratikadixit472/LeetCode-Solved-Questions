class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int n = mat.length, m = mat[0].length;
        
        int[][] pref = new int[n+1][m+1];
        
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <= m; j++){
                pref[i][j] = mat[i-1][j-1] + pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1];
            }
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                int r1 = Math.max(0, i - k), c1 = Math.max(0, j - k);
                int r2 = Math.min(n-1, i + k), c2 = Math.min(m-1, j + k);
                
                r1++; c1++; r2++; c2++;
                
                mat[i][j] = pref[r2][c2] - pref[r1-1][c2] - pref[r2][c1-1] + pref[r1-1][c1-1];
            }
        }
        return mat;
    }
}
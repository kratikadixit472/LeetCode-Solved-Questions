class Solution {
    public void setZeroes(int[][] mat) {
        
        boolean row = false, col = false;
        int n = mat.length, m = mat[0].length;
        if(mat == null || (n==0 && m == 0))return;
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                    if(i == 0) row = true;
                    if(j == 0) col = true;
                }
            }
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }
        if(row){
            for(int i=0; i<m; i++){
                mat[0][i] = 0;
            }
        }
        if(col){
            for(int j=0; j<n; j++){
                mat[j][0] = 0;
            }
        }
    }
}
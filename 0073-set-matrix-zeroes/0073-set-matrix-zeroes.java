class Solution {
    int MAX_VALUE = (int)(1e9 + 7);
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][j] = MAX_VALUE;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == MAX_VALUE){
                    makeZero(matrix, i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == MAX_VALUE){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    private void makeZero(int[][] mat, int r, int c){
        
        for(int i = 0 ; i < mat[0].length; i++){
            if(mat[r][i] != MAX_VALUE) mat[r][i] = 0;
        }
        for(int i = 0 ; i < mat.length; i++){
            if(mat[i][c] != MAX_VALUE) mat[i][c] = 0;
        }
    } 
}
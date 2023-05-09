class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        int n = mat1.length, m = mat2[0].length, l = mat1[0].length;
        int[][] mat = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < l; j++){
                if(mat1[i][j] != 0){
                    for(int k = 0; k < m; k++){
                        mat[i][k] += mat1[i][j] * mat2[j][k];
                    }
                }
            }
        }
        return mat;
    }
}
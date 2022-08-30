class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1 ; j < m; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = tmp;
            }
        }
    }
}
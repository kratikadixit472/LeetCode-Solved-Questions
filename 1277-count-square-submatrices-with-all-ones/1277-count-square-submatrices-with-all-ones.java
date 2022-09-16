class Solution {
    int n, m;
    public int countSquares(int[][] matrix) {
        n = matrix.length; m = matrix[0].length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(matrix[i][j] > 0 && i > 0 && j > 0){
                
                int min =  Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                matrix[i][j] = min + 1;
                }
                count += matrix[i][j];
            }   
        }
        return count;
    }
}
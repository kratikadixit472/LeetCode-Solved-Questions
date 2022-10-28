class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int left = 0, up = 0, down = n-1, right = n-1, cnt = 1;
        
        while(left <= right && up <= down){
            for(int i = left; i <= right; i++){
                matrix[up][i] = cnt++;
            }
            up++;
            
            for(int i = up ; i <= down; i++){
                matrix[i][right] = cnt++;
            }
            right--;
            
            if(down >= up ){
                for(int i = right; i >= left; i--){
                    matrix[down][i] = cnt++;
                }
            }
            down--;
            
            if(right >= left){
                for(int i = down; i >= up; i--){
                    matrix[i][left] = cnt++;
                }
            }
            left++;
        }
        
        return matrix;
    }
}
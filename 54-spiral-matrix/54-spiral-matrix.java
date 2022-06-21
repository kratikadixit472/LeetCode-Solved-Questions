class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> al = new ArrayList<>();
        
        int row = 0, col = 0;
        int lower = matrix.length-1, upper = matrix[0].length-1;
        
        while(row <= lower && col <= upper){
        for(int i = col; i <= upper; i++){
            al.add(matrix[row][i]);
        }
        row++;
        
        for(int j = row ; j <= lower; j++){
            al.add(matrix[j][upper]);
        }
        upper--;
        
        if(row <= lower){
        for(int i = upper ; i>=col; i--){
            al.add(matrix[lower][i]);
        }
        }
        lower--;
        
        if(col <= upper){
        for(int j = lower ; j>=row; j--){
            al.add(matrix[j][col]);
        }
        }
        col++;
        }
        return al;
        
    }
}
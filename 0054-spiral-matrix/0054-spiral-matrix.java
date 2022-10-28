class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        
        int left = 0, up = 0, down = n-1, right = m-1;
        
        while(left <= right && up <= down){
            for(int i = left; i <= right; i++){
                ans.add(matrix[up][i]);
            }
            up++;
            
            for(int i = up ; i <= down; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            
            if(down >= up ){
                for(int i = right; i >= left; i--){
                    ans.add(matrix[down][i]);
                }
            }
            down--;
            
            if(right >= left){
                for(int i = down; i >= up; i--){
                    ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }
   
}
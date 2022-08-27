class Solution {
    int ans;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int n = matrix.length, m = matrix[0].length;
        ans = Integer.MIN_VALUE;
        
        for(int r1 = 0;  r1 < n; r1++){
            
            int[] arr = new int[m];
            for(int r2 = r1; r2 < n; r2++){
                for(int c = 0; c < m; c++) arr[c] += matrix[r2][c]; 
                ans = Math.max(ans, getMaxSubarray(arr, k));
            }
        }
        return ans;
    }
    
    private int getMaxSubarray(int[] arr, int k){
        
        int right = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        for(int i = 0;  i < arr.length; i++){
            right += arr[i];
            
            Integer left = set.ceiling(right - k);
            
            if(left != null){
                ans = Math.max(ans, right - left);
            }
            set.add(right);
        }
        return ans;
    }
}
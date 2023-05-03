class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
       
        Map<Integer, int[]> map = new HashMap<>();
        
        int[] row = new int[n];
        int[] col = new int[m];
        
        int N = arr.length;
        
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        
        for(int i = 0 ; i < N; i++){
            int[] a = map.get(arr[i]);
            
            row[a[0]]++;
            col[a[1]]++;
            
            if(row[a[0]] == m || col[a[1]] == n) return i;
        }
        return -1;
    }
    
}
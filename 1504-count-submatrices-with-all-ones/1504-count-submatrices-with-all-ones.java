class Solution {
    public int numSubmat(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        int res = 0;
        int[] h = new int[m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                h[j] = (mat[i][j] == 0) ? 0 : h[j] + 1;
                for(int k = j, min = h[j]; k >= 0 && min > 0 ; k--){
                    min = Math.min(min, h[k]);
                    res += min;
                }
            }
        }
        return res;
    }
}
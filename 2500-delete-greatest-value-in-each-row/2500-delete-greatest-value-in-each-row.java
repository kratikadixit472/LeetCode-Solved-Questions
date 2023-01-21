class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        
        for(int[] d : grid){
            Arrays.sort(d);
        }
        
        for(int j = 0 ; j < m; j++){
            int maxVal = 0;
            for(int i = 0; i < n; i++){
                maxVal = Math.max(maxVal, grid[i][j]);
            }
            ans += maxVal;
        }
        return ans;
    }
}
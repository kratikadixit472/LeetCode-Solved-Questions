class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), m = triangle.get(n-1).size();
        return getMinAns(0, 0, n, triangle, new Integer[n][m]);
    }
    
    private int getMinAns(int row, int col, int n, List<List<Integer>> triangle, Integer[][] dp){
        
        if(row >= n || col > triangle.get(row).size()) return 0;
        
        if(dp[row][col] != null) return dp[row][col];
        
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        
        first = triangle.get(row).get(col) + getMinAns(row+1, col, n, triangle, dp);
        
        if(col+1 < triangle.get(row).size()){
            second = triangle.get(row).get(col+1) + getMinAns(row+1, col+1, n, triangle, dp);
        }
        
        return dp[row][col] = Math.min(first, second);
    }
}
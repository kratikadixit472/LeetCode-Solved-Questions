class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        Integer[][] dp = new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
        
        return  getMinPath(0,0, triangle.size()-1, triangle, dp);
    }
    
    private int getMinPath(int row, int col, int er, List<List<Integer>> triangle, Integer[][] dp){
        if(row > er || col >= triangle.get(row).size()) return 0;
        
        if(dp[row][col] != null) return dp[row][col];
        
        int min = (int)(1e9 + 7);
        
        for(int i = col; i <= col+1 && i < triangle.get(row).size(); i++){
            min = Math.min(min, triangle.get(row).get(i) + getMinPath(row+1, i, triangle.size()-1, triangle, dp));
        }
        dp[row][col] = min;
        return dp[row][col];
    }
}
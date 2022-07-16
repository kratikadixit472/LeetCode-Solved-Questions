class Solution {
    
    static int[][] direc = {{-1,0},{0,1},{1,0},{0,-1}};
    static int mod = (int)1e9+7;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[maxMove+1][m][n];
        
        return paths(m,n,maxMove,startRow,startColumn,dp);
        
    }
    private int paths(int m,int n,int maxMove,int row,int col,Integer[][][] dp){
        if(row<0 || row==m || col<0 || col==n){
            return 1;
        }
        if(maxMove==0) return 0;
        if(dp[maxMove][row][col]!=null) return dp[maxMove][row][col];
        int path = 0;
        for(int[] dir:direc){
            int x = dir[0] + row;
            int y = dir[1] + col;
            
            path = (path + paths(m,n,maxMove-1,x,y,dp)) % mod; 
        }
        return dp[maxMove][row][col] = path;

    }
}
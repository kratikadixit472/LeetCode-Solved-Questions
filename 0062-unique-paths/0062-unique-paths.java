class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return DFS(0, 0, m-1, n-1, dp);
    }
    
    private int DFS(int sr, int sc, int er, int ec, Integer[][] dp){
        
        if(sr == er && sc == ec) return dp[sr][sc] = 1;
        if(dp[sr][sc] != null) return dp[sr][sc];
        int count = 0 ;
        
        if(sr + 1 <= er){
            count += DFS(sr + 1, sc, er, ec, dp);
        }
        if(sc + 1 <= ec){
            count += DFS(sr, sc + 1, er, ec, dp);
        }
        return dp[sr][sc] = count;
    }
}
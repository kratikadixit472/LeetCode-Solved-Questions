class Solution {
    int[] piles;
    Integer[][][] dp;
    
    public int stoneGameII(int[] piles) {
        this.piles = piles;
        dp = new Integer[2][piles.length + 1][piles.length + 1];
        
        return dfs(0, 0, 1);
    }
    
    private int dfs(int p, int i, int m) {
        if (i >= piles.length)
            return 0;
        
        if (dp[p][i][m] != null) 
            return dp[p][i][m];
        
        int res = p == 0 ? 0 : 1000000;
        int total = 0;
        
        for (int x = 1; x <= 2 * m; x++) {
            if (i + x > piles.length)
                break;
            
            total += piles[i + x - 1];
            
            if (p == 0)
                res = Math.max(res, total + dfs(1, i + x, Math.max(m, x)));
            else
                res = Math.min(res, dfs(0, i + x, Math.max(m, x)));
        }
        
        return dp[p][i][m] = res;
    }
}
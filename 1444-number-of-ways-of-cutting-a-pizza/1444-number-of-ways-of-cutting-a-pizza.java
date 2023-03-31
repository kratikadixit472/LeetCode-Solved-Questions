class Solution {
    public int ways(String[] pizza, int k) {
        int n = pizza.length, m = pizza[0].length();
        int mod = 1000000007;
        
        int apples[][] = new int[n + 1][m + 1];
        int dp[][][] = new int[k][n][m];
        
        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) + apples[row + 1][col] + apples[row][col + 1]
                        - apples[row + 1][col + 1];
                dp[0][row][col] = apples[row][col] > 0 ? 1 : 0;
            }
        }
        
        for (int remain = 1; remain < k; remain++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    for (int next_row = row + 1; next_row < n; next_row++) {
                        if (apples[row][col] - apples[next_row][col] > 0) {
                            dp[remain][row][col] += dp[remain - 1][next_row][col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                    for (int next_col = col + 1; next_col < m; next_col++) {
                        if (apples[row][col] - apples[row][next_col] > 0) {
                            dp[remain][row][col] += dp[remain - 1][row][next_col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                }
            }
        }
        return dp[k - 1][0][0];
    }
}
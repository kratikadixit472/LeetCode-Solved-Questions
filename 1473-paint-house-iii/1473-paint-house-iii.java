class Solution {

    int[][][] dp = new int[101][101][22];
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        for(int[][] grid : dp) for(int[] row : grid) Arrays.fill(row, -1);
        int result = solve(houses, cost, m, n, target, 0, 0, 0);
        return result == Integer.MAX_VALUE/2 ? -1 : result;
    }

    private int solve(int[] houses, int[][] cost, int m, int n, int target, int index, int neighbours, int lastHouseColor) {
        if (neighbours > target) return Integer.MAX_VALUE/2;

        if(dp[index][neighbours][lastHouseColor] != -1) 
            return dp[index][neighbours][lastHouseColor];
        
        if (index == m) {
            return target == neighbours ? 0 : Integer.MAX_VALUE/2;
        } else {
            int result = Integer.MAX_VALUE/2;
            if(houses[index] == 0){
                for(int j = 0; j < n; j++){
                    result = Math.min(result, cost[index][j] + solve(houses, cost, m, n, target, index + 1, (lastHouseColor == j + 1) ? neighbours : neighbours + 1, j + 1));
                }
            }else{
                result = Math.min(result, solve(houses, cost, m, n, target, index + 1, (lastHouseColor == houses[index]) ? neighbours : neighbours + 1, houses[index]));
            }
            return dp[index][neighbours][lastHouseColor] = result;
        }
    }
}
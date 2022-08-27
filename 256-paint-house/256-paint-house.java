class Solution {
    public int minCost(int[][] costs) {
        
        int n = costs.length;
        int[][] dp = new int[n][3];
        
        return Math.min(findMinCost(0, costs, 0, dp), Math.min(findMinCost(0, costs, 1, dp), findMinCost(0, costs, 2, dp)));
    }
    
    private int  findMinCost(int idx, int[][] costs, int color, int[][] dp){
        
        int totalcost = costs[idx][color];
        
        if(idx == costs.length - 1) return totalcost;
        
        if(dp[idx][color] != 0) return dp[idx][color];
        
        if(color == 0){
            totalcost += Math.min(findMinCost(idx+1, costs, 1, dp), findMinCost(idx+1, costs, 2, dp));
        }
        else if(color == 1){
            totalcost += Math.min(findMinCost(idx+1, costs, 0, dp), findMinCost(idx+1, costs, 2, dp));
        }
        else{
            totalcost += Math.min(findMinCost(idx+1, costs, 0, dp), findMinCost(idx+1, costs, 1, dp));
        }
        dp[idx][color] = totalcost;
        
        return dp[idx][color];
    }
}
class Solution {
    public int minCostII(int[][] costs) {
        
        return getMinCost(0, 0, costs);
        
    }
    
    private int getMinCost(int row, int col, int[][] costs){
        
        int n = costs.length, m = costs[0].length;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < m; k++){
                    
                    if(j == k) continue;
                    min = Math.min(min, costs[i-1][k]);
                }
                costs[i][j] += min;
            }
        }
        int totalMinCost = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i++){
            totalMinCost = Math.min(totalMinCost, costs[n-1][i]);
        }
        return totalMinCost;
    }
}
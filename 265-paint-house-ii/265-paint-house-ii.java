class Solution {
    public int minCostII(int[][] costs) {
        
        return getMinCost(0, 0, costs);
        
    }
    
    private int getMinCost(int row, int col, int[][] costs){
        
        int n = costs.length, m = costs[0].length;
        
        for(int house = 1; house < n; house++){
            
            int minC = -1, secMinC = -1;
            for(int color = 0; color < m; color++){
                
                int cost = costs[house-1][color];
                
                if(minC == -1 || cost < costs[house-1][minC]){
                    secMinC = minC;
                    minC = color;
                }
                else if(secMinC == -1 || costs[house-1][secMinC] > cost){
                    secMinC = color;
                }
            }
            
            for(int color = 0; color < m; color++){
                
                if(minC == color){
                    costs[house][color] += costs[house-1][secMinC];
                }
                else{
                    costs[house][color] += costs[house-1][minC];
                }
            }
        }
        int totalMinCost = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i++){
            totalMinCost = Math.min(totalMinCost, costs[n-1][i]);
        }
        return totalMinCost;
    }
}
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] minCost = new int[n];
        
        for(int i = 0; i < n; i++){
            
            if(i == 0 || i == 1){
                minCost[i] = cost[i];
                continue;
            }
            
            minCost[i] = Math.min(minCost[i-1], minCost[i-2]) + cost[i];
        }
        return Math.min(minCost[n-1], minCost[n-2]);
        
    }
}
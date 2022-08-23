class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        
        int first = cost[0]; 
        int second = cost[1]; 
        
        if(n <= 2) return Math.min(first, second);
        
        for(int i = 2; i < n; i++){
            int curr = Math.min(first, second) + cost[i] ;
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}
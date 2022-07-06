class Solution {
    public int minCost(int[][] costs) {
        
        int n = costs.length;
        
        if(n == 0) return 0;
        
        int lastR = costs[0][0];
        int lastG = costs[0][1];
        int lastB = costs[0][2];
        
        for(int i = 1; i < n; i++){
            int currR = Math.min(lastG, lastB) + costs[i][0];
            int currG = Math.min(lastR, lastB) + costs[i][1];
            int currB = Math.min(lastR, lastG) + costs[i][2];
            
            lastR = currR;
            lastG = currG;
            lastB = currB;
        }
        
        return Math.min(lastR, Math.min(lastG, lastB));
    }
}
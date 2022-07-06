class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
         
        for(int i = 1; i < n; i++){
            for(int j = 0; j < costs[0].length; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < costs[0].length; k++){
                    if(k != j){
                        if(min > costs[i-1][k]){
                            min = costs[i-1][k];
                        }
                    }
                }
                costs[i][j] = min + costs[i][j];
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < costs[0].length; i++){
            ans = Math.min(costs[n-1][i], ans);
        }
        
        return ans;
    }
}
class Solution {
    public int minCostII(int[][] costs) {
        
        int n = costs.length, m = costs[0].length;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                
                int min = Integer.MAX_VALUE;
                
                for(int k = 0; k < m; k++){
                    if(j != k){
                        min = Math.min(min, costs[i-1][k]);
                    }
                }
                
                costs[i][j] += min;
            }
            
        }
        
        for(int cost : costs[n-1]){
            ans = Math.min(cost, ans);
        }
        
        return ans;
    }
}
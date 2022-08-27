class Solution {
    public int minCost(int[][] costs) {
        
        int n = costs.length;
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                
                if(j == 0) {
                    costs[i][j] += Math.min(costs[i-1][j+1], costs[i-1][j+2]); 
                }
                else if(j == 1) {
                    costs[i][j] += Math.min(costs[i-1][j-1], costs[i-1][j+1]); 
                }
                else{
                    costs[i][j] += Math.min(costs[i-1][j-1], costs[i-1][j-2]); 
                }
            }
            
        }
        
        for(int cost : costs[n-1]){
            ans = Math.min(cost, ans);
        }
        
        return ans;
    }
}
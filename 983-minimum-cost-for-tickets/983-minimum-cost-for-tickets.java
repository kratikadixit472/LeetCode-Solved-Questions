class Solution {
    
    Set<Integer> set;
    int[] costs;
    
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        
        set = new HashSet<>();
        
        for(int d : days) set.add(d);
        
        int n = days.length;
        int[] dp = new int[366];
        
        for(int i = 1; i <= 365; i++){
            
            if(set.contains(i)){
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0, i-7)] + costs[1], dp[Math.max(0,i-30)] + costs[2]));
            }
            
            else {
                dp[i] = dp[i-1];
            }
        }
        return dp[365];
    }
}
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[366];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int d : days) set.add(d);

        return getCost(1, costs, set, dp);
    }
    private int getCost(int i, int[] costs,Set<Integer> set, int[] dp) {

        if(i > 365) return 0;
        if(dp[i] != Integer.MAX_VALUE) return dp[i];
        int ans = 0;

        if(set.contains(i)){
            ans = Math.min(getCost(i+1, costs, set, dp) + costs[0], Math.min(getCost(i+7, costs, set, dp) + costs[1], getCost(i+30, costs, set, dp) + costs[2]));
        }
        else{
            ans = getCost(i+1, costs, set, dp);
        }
        return dp[i] = ans;
    }
}
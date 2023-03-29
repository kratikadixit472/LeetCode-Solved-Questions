class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return getMinTime(satisfaction, dp, 0, 1);
    }
    
    private int getMinTime(int[] sat, int[][] dp, int idx, int time){
        
        if(idx == sat.length) return 0;
        
        if(dp[idx][time] != -1) return dp[idx][time];
        
        return dp[idx][time] = Math.max(sat[idx] * time + getMinTime(sat, dp, idx+1, time+1), getMinTime(sat, dp, idx+1, time));
        
    }
}
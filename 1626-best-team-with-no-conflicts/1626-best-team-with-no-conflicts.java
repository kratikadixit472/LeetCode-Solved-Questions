class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int n = scores.length;
        int[][] mem = new int[n][2];
        
        for(int i = 0; i < n; i++){
            mem[i][1] = ages[i];
            mem[i][0] = scores[i];
        }
        Integer[][] dp = new Integer[n][n];
        
        Arrays.sort(mem, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        return getTeam(-1, 0, n, mem, dp);
    }
    
    private int getTeam(int prev, int next, int n, int[][] mem, Integer[][] dp){
        if(next >= n) return 0;
        
        if(dp[prev+1][next] != null) return dp[prev+1][next];
        
        if(prev == -1 || mem[next][0] >= mem[prev][0]){
            return dp[prev+1][next] = Math.max(mem[next][0] + getTeam(next, next+1, n, mem, dp), getTeam(prev, next+1, n, mem, dp));
        }
        
        return dp[prev+1][next] = getTeam(prev, next+1, n, mem, dp);
    }
}
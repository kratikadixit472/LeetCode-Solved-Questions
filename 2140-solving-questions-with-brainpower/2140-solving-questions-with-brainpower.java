class Solution {
    public long mostPoints(int[][] questions) {
        return DFS(0, questions, new long[questions.length]);
    }
    
    private long DFS(int i, int[][] arr, long[] dp){
        
        if(i >= arr.length) return 0;
        
        if(dp[i] != 0) return dp[i];
        
        return dp[i] = Math.max(arr[i][0] + DFS(i + arr[i][1] + 1, arr, dp), DFS(i + 1, arr, dp));
    }
}
class Solution {
    public int minCost(int n, int[] cuts) {
        
        int[] arr = new int[cuts.length + 2];
        
        for(int i = 0; i < cuts.length; i++){
            arr[i + 1] = cuts[i];
        }
        
        arr[arr.length - 1] = n;
        Arrays.sort(arr);
        
        int[][] dp = new int[arr.length][arr.length];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = i - 1; j >= 0; j--){
                for(int k = i - 1; k > j; k--){
                    int ans = Math.min(dp[j][i] == 0 ? Integer.MAX_VALUE : dp[j][i], arr[i] - arr[j] + dp[j][k] + dp[k][i]);
                    dp[j][i] = ans;

                }
            }
        }
        return dp[0][arr.length - 1]; 
    }
}
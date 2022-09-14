class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int m = triangle.get(triangle.size()-1).size();
        int n = triangle.size();
        int[] dp = new int[m];
        
        for(int i = 0; i < m; i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        
        for(int layer = n-2; layer >= 0; layer--){
            for(int i = 0; i <= layer; i++){
                dp[i] = Math.min(dp[i+1], dp[i]) + triangle.get(layer).get(i);
            }
        }
        return dp[0];
    }
}
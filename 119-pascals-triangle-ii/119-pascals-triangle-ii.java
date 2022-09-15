class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        int[][] dp = new int[rowIndex+1][rowIndex+1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= rowIndex; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int ele : dp[rowIndex]){
            ans.add(ele);
        }
        return ans;
    }
}
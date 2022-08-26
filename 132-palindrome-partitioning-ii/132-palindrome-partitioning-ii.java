class Solution {
    public int minCut(String s) {
       
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int jump = 0; jump<n; jump++){
            for(int i=0, j = jump; j < n; j++, i++){
                if(jump == 0){
                    dp[i][j] = true;
                }
                else if(jump == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
            }
        }
        
        int[] store = new int[n];
        
        for(int j = 0; j < dp.length; j++){
            if(dp[0][j]){
                store[j] = 0;
            }
            else{
                int min = Integer.MAX_VALUE;
                for(int i = j; i>=1; i--){
                    if(dp[i][j]){
                        if(store[i-1] < min){
                            min = store[i-1];
                        }
                    }
                }
                store[j] = min + 1;
            }
        }
        return store[n-1];
    }
}
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length, max = 0;
        
        int[] dp = new int[n];
        
        int len = 0;
        int[] sec = new int[n];
        
        for(int i = 0; i < n; i++){
            sec[i] = envelopes[i][1];
        }
        
        for(int num : sec){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0) i = -(i + 1);
            
            dp[i] = num;
            if(i == len) len++;
        }
        return len;
    }
}
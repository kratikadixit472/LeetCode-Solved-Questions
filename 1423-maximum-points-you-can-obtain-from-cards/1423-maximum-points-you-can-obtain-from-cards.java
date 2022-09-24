class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int[] frontSum = new int[k+1];
        int[] rearSum = new int[k+1];
        int n = cardPoints.length;
        
        int ans = 0;
        
        for(int i = 0; i < k; i++){
            frontSum[i+1] = frontSum[i] + cardPoints[i];
            rearSum[i+1] = rearSum[i] + cardPoints[n-i-1];
        }
        
        for(int i = 0; i <= k; i++){
            ans = Math.max(ans, frontSum[i] + rearSum[k-i]);
        }
        return ans;
    }
}
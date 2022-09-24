class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int presentSum = 0;
        int totalSum = 0;
        
        for(int i = 0; i < n; i++){
            totalSum += cardPoints[i];
        }
        int j = 0;
        
        if(k == n) return totalSum;
        int minWindow = totalSum;
        
        for(int i = 0; i < n; i++){
            presentSum += cardPoints[i];
            
            if(i - j + 1 == n - k){
                minWindow = Math.min(presentSum, minWindow);
                presentSum -= cardPoints[j++];
            }
        }
        return totalSum - minWindow;
    }
}
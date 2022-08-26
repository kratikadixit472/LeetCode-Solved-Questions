class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int minCap = 0;
        
        for(int w : weights) minCap = Math.max(w, minCap);
        
        while(true){
            
            int n = 1, pkg = weights.length;
            for(int i = 0, weightSum = 0; i < pkg && n <= days; i++){
                
                if(n + (pkg - i) == days) return minCap;
                
                weightSum += weights[i];
                
                if(weightSum > minCap){
                    n++;
                    weightSum = weights[i];
                }
            }
            if(n == days) break;
            minCap++;
        }
        return minCap;
    }
}
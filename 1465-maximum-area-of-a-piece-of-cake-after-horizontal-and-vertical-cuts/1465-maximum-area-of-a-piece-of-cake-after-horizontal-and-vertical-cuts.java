class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHgt = 0, maxWdt = 0;
        int n = horizontalCuts.length, m = verticalCuts.length;
        long mod = (1000000007);
        
        maxHgt = Math.max(horizontalCuts[0], h - horizontalCuts[n-1]);
        
        for(int i = 1; i < n; i++){
            maxHgt = Math.max(maxHgt, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        
        maxWdt = Math.max(verticalCuts[0], w - verticalCuts[m-1]);
        
        for(int i = 1; i < m; i++){
            maxWdt = Math.max(maxWdt, verticalCuts[i] - verticalCuts[i-1]);
        }
        
        return (int)((maxHgt * maxWdt) % mod);
    }
}
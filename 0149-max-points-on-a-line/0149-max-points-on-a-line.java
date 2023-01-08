class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length, ans = 0;
        
        for(int i = 0; i < n; i++){
            Map<Double, Integer> map = new HashMap<>();
            for(int j = i + 1; j < n; j++){
                
                int[] x = points[i], y = points[j];
                double slop = getSlop(x, y);
                
                map.put(slop, map.getOrDefault(slop, 0) + 1);
                
                ans = Math.max(ans, map.get(slop));
            }
        }
        return ans + 1;
    }
    
    private double getSlop(int[] x, int[] y){
        int x1 = x[0], x2 = y[0];
        int y1 = x[1], y2 = y[1];
        
        if(x1 == x2) return Double.MAX_VALUE;
        if(y1 == y2) return 0;
        
        return (double) (y2 - y1) / (double) (x2 - x1);
    }
}
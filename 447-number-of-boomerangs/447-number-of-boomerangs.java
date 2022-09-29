class Solution {
    
    private int getDistance(int[] p1, int[] p2){
        
        int x = Math.abs(p1[0] - p2[0]), y = Math.abs(p2[1] - p1[1]);
        
        return x * x + y * y;
    }
    public int numberOfBoomerangs(int[][] points) {
        
        int n = points.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                int dis = getDistance(points[i], points[j]);
                
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            
            for(int val : map.values()){
                if(val <= 1) continue;
                ans += val * (val - 1);
            }
            map.clear();
        }
        return ans;
    }
    
}
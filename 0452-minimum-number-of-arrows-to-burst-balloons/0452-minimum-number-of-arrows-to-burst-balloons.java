class Solution {
    public int findMinArrowShots(int[][] points) {
        
        if(points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 1;
        int prev = points[0][1];

        for(int[] point : points){
            if(point[0] <= prev){
                continue;
            }
            prev = point[1];
            cnt++;
        }
        return cnt;
    }
}
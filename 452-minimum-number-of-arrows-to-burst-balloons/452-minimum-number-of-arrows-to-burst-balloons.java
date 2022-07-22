class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int balloons = 1;
        int start_end = points[0][1];
        
        for(int[] point : points){
            
            if(start_end < point[0]){
                start_end = point[1];
                balloons++;
            }
        }
        
        return balloons;
    }
}
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int left = 1, right = 10000000;
        int speed = -1;
        
        while(left <= right){
            
            int mid = (left + right) / 2;
            
            if(getTime(dist, mid) <= hour){
                speed = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return speed;
    }
    
    private double getTime(int[] dist, double speed){
        double tTotal = 0.0;
        
        for(int i = 0; i < dist.length; i++){
            double time = (double) dist[i] / (double)speed;
            tTotal += (i == dist.length - 1) ? time : Math.ceil(time);
        }
        return tTotal;
    }
}
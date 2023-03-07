class Solution {
    public boolean timeEnough(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        for (int t : time) 
            actualTrips += givenTime / t;
        return actualTrips >= totalTrips;
    }
    
    public long minimumTime(int[] time, int totalTrips) {

        int max_time = 0;
        for (int t : time) {
            max_time = Math.max(max_time, t);
        }
        long left = 1, right = (long) max_time * totalTrips;

        while (left < right) {
            long mid = (left + right) / 2;
            if (timeEnough(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
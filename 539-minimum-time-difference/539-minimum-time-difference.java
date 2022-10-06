class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] time = new int[timePoints.size()];
        int idx = 0;
        
        for(String s : timePoints){
            int t = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
            time[idx++] = t;
        }
        Arrays.sort(time);
        
        int first = time[0];
        int prev = first;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i < time.length; i++){
            ans = Math.min(ans, time[i] - prev);
            prev = time[i];
        }
        return Math.min(ans, 1440 + first - prev);
    }
}


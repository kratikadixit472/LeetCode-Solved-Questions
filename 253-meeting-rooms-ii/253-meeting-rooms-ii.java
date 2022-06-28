class Solution {
    public int minMeetingRooms(int[][] intervals) {
       
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
             start[i] = intervals[i][0];
             end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int[] interval = intervals[0];
        int ans = 1, idx = 0;
        
        for(int i = 1; i < intervals.length; i++){
            
            if(start[i] < end[idx]) ans++;
            
            else idx++;
        }
        return ans;
    }
}
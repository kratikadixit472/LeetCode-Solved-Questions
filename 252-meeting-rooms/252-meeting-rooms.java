class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals.length <= 1) return true;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] interval = intervals[0];
        
        for(int i = 1; i < intervals.length; i++){
            if(interval[1] > intervals[i][0]){
                return false;
            }
            else{
                interval = intervals[i];
            }
        }
        return true;
    }
}
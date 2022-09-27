class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals , (a, b) -> a[0] - b[0]);
        if(intervals.length < 1) return true;
        
        int[] interval = intervals[0];
        
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(interval[1] > curr[0]){
                return false;
            }
            else{
                interval = curr;
            }
        }
        return true;
    }
}
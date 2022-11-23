class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        int[] interval = intervals[0];
        int cnt = 0;
        
        for(int i = 1; i < intervals.length; i++){
            if(interval[1] > intervals[i][0]) {
                cnt++;
                interval[1] = Math.min(interval[1], intervals[i][1]);
            }
            else{
                interval = intervals[i];
            }
        }
        return cnt;
    }
}
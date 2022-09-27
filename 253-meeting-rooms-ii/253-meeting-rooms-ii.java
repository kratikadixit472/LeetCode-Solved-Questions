class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i =0 ; i < n; i++){
            int[] interval = intervals[i];
            start[i] = interval[0];
            end[i] = interval[1];
        }
        
        Arrays.sort(start); Arrays.sort(end);
        
        int rooms = 0, endIdx = 0;
        
        for(int i = 0; i < intervals.length; i++){
            if(start[i] < end[endIdx]){
                rooms++;
            }
            else{
                endIdx++;
            }
        }
        return rooms;
    }
}
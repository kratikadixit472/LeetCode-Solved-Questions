class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] interval = intervals[0];
        int n = intervals.length;
        List<int[]> al = new ArrayList<>();
        
        for(int i = 1; i < n; i++){
            if(intervals[i][0] <= interval[1]){
                interval[0] = Math.min(intervals[i][0], interval[0]);
                interval[1] = Math.max(intervals[i][1], interval[1]);
            }
            else {
                al.add(interval);
                interval = intervals[i];
            }
        }
        al.add(interval);
        
        int[][] ans = new int[al.size()][2];
        int idx = 0;
        
        for(int[] all : al){
            ans[idx][0] = all[0];
            ans[idx++][1] = all[1];
        }
        return ans;
    }
}
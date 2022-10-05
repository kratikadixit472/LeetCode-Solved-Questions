class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> al = new ArrayList<>();
        
        int[] interval = intervals[0];
        
        for(int i = 1; i < intervals.length; i++){
            if(interval[1] >= intervals[i][0]){
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
            else{
                al.add(interval);
                interval = intervals[i];
            }
        }
        al.add(interval);
          
        int[][] ans = new int[al.size()][2];
        int idx = 0;
        
        for(int[] a : al){
            ans[idx][0] = a[0];
            ans[idx++][1] = a[1];
        }
        
        return ans;
    }
}
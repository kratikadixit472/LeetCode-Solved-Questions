class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals , (a, b) -> a[0] - b[0]);
        
        int[] interval = intervals[0];
        List<int[]> al = new ArrayList<>();
        
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(interval[1] >= curr[0]){
                interval[1] = Math.max(interval[1], curr[1]);
            }
            else{
                al.add(interval);
                interval = curr;
            }
        }
        al.add(interval);
        
        int[][] res = new int[al.size()][2];
        for(int i = 0; i < al.size(); i++){
            res[i] = al.get(i);
        }
        return res;
    }
}
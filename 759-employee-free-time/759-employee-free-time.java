/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        List<Interval> ans = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        
        int n = schedule.size();
        for(int i = 0; i < n; i++) pq.add(new int[]{i, 0});
        
        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).start;
        
        while(!pq.isEmpty()){
            
            int[] next = pq.poll();
            Interval interval = schedule.get(next[0]).get(next[1]);
            
            if(interval.start > prev){
                ans.add(new Interval(prev, interval.start));
            }
            
            prev = Math.max(prev, interval.end);
            
            if(schedule.get(next[0]).size() > next[1] + 1){
                pq.add(new int[]{next[0], next[1]+1});
            }
        }
        return ans;
    }
}
// int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).start;
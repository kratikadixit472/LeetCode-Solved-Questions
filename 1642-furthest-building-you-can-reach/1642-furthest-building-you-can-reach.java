class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int usedbricks =0;
        
        for(int i=1; i<heights.length; i++){
            if(heights[i-1] < heights[i]){
                int diff = heights[i] - heights[i-1];
                pq.add(diff);
                if(pq.size() > ladders){
                    int tmp = pq.poll();
                    usedbricks += tmp;
                    if(usedbricks > bricks) return i-1;
                }
            }
        }
        return heights.length - 1;
    }
}
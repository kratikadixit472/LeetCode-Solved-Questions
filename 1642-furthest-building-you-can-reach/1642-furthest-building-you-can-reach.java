class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        
        for(int i = 0; i < n-1; i++){
            int climb = heights[i+1] - heights[i];
            
            if(climb <= 0) continue;
            
            pq.add(climb);
            
            if(pq.size() <= ladders) continue;
            else{
                bricks -= pq.poll();
            }
            if(bricks < 0) return i;
        }
        return n-1;
    }
}
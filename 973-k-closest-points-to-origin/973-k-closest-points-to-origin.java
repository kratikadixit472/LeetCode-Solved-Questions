class Solution {
    class Pair{
        
        int dist, x, y;
        
        public Pair(int dist, int x, int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return b.dist - a.dist; 
        });
        
        
        for(int[] point : points){
            pq.add(new Pair((point[0]*point[0] + point[1] * point[1]), point[0], point[1]));
            if(pq.size() > k) pq.poll();
        }
        
        int idx = 0;
        int[][] res = new int[pq.size()][2];
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            res[idx][0] = p.x;
            res[idx++][1] = p.y;
        }
        
        return res;
    }
}